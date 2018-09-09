package ch.leadrian.samp.kamp.runtime.entity

import ch.leadrian.samp.kamp.api.constants.SAMPConstants
import ch.leadrian.samp.kamp.api.data.mutableVector2DOf
import ch.leadrian.samp.kamp.api.data.vector2DOf
import ch.leadrian.samp.kamp.api.entity.Menu
import ch.leadrian.samp.kamp.api.entity.MenuRow
import ch.leadrian.samp.kamp.api.entity.Player
import ch.leadrian.samp.kamp.api.entity.id.MenuId
import ch.leadrian.samp.kamp.api.entity.id.PlayerId
import ch.leadrian.samp.kamp.api.exception.AlreadyDestroyedException
import ch.leadrian.samp.kamp.api.exception.CreationFailedException
import ch.leadrian.samp.kamp.api.text.TextFormatter
import ch.leadrian.samp.kamp.api.text.TextKey
import ch.leadrian.samp.kamp.api.text.TextProvider
import ch.leadrian.samp.kamp.runtime.SAMPNativeFunctionExecutor
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import io.mockk.verifyOrder
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.catchThrowable
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import java.util.*

internal class MenuImplTest {

    @Nested
    inner class ConstructorTests {

        @Test
        fun shouldConstructMenu() {
            val menuId = MenuId.valueOf(69)
            val nativeFunctionExecutor = mockk<SAMPNativeFunctionExecutor> {
                every {
                    createMenu(
                            title = "Hi there",
                            x = 1f,
                            y = 2f,
                            col1width = 5f,
                            col2width = 10f,
                            columns = 2
                    )
                } returns menuId.value
            }

            val menu = MenuImpl(
                    numberOfColumns = 2,
                    title = "Hi there",
                    locale = Locale.GERMANY,
                    position = vector2DOf(x = 1f, y = 2f),
                    columnWidth1 = 5f,
                    columnWidth2 = 10f,
                    nativeFunctionExecutor = nativeFunctionExecutor,
                    textFormatter = mockk(),
                    textProvider = mockk()
            )

            assertThat(menu.id)
                    .isEqualTo(menuId)
        }

        @Test
        fun givenCreateMenuReturnsInvalidMenuIdItShouldThrowCreationFailedException() {
            val nativeFunctionExecutor = mockk<SAMPNativeFunctionExecutor> {
                every {
                    createMenu(
                            title = "Hi there",
                            x = 1f,
                            y = 2f,
                            col1width = 5f,
                            col2width = 10f,
                            columns = 2
                    )
                } returns SAMPConstants.INVALID_MENU
            }

            val caughtThrowable = catchThrowable {
                MenuImpl(
                        numberOfColumns = 2,
                        title = "Hi there",
                        locale = Locale.GERMANY,
                        position = vector2DOf(x = 1f, y = 2f),
                        columnWidth1 = 5f,
                        columnWidth2 = 10f,
                        nativeFunctionExecutor = nativeFunctionExecutor,
                        textFormatter = mockk(),
                        textProvider = mockk()
                )
            }

            assertThat(caughtThrowable)
                    .isInstanceOf(CreationFailedException::class.java)
        }
    }

    @Nested
    inner class PostConstructionsTests {

        private val menuId = MenuId.valueOf(69)
        private val locale = Locale.GERMANY
        private lateinit var menu: MenuImpl

        private val nativeFunctionExecutor = mockk<SAMPNativeFunctionExecutor>()
        private val textProvider = mockk<TextProvider>()
        private val textFormatter = mockk<TextFormatter>()

        @BeforeEach
        fun setUp() {
            every { nativeFunctionExecutor.createMenu(any(), any(), any(), any(), any(), any()) } returns menuId.value
            menu = MenuImpl(
                    numberOfColumns = 2,
                    title = "Hi there",
                    locale = locale,
                    position = mutableVector2DOf(x = 1f, y = 2f),
                    columnWidth1 = 5f,
                    columnWidth2 = 10f,
                    nativeFunctionExecutor = nativeFunctionExecutor,
                    textFormatter = textFormatter,
                    textProvider = textProvider
            )
        }

        @Test
        fun shouldInitializePosition() {
            val position = menu.position

            assertThat(position)
                    .isEqualTo(vector2DOf(x = 1f, y = 2f))
        }

        @Nested
        inner class AddItemTests {

            @ParameterizedTest
            @ValueSource(ints = [0, 1])
            fun shouldAddMenuItem(column: Int) {
                every { nativeFunctionExecutor.addMenuItem(any(), any(), any()) } returns 0

                menu.addItem(column, "Hi there")

                verify { nativeFunctionExecutor.addMenuItem(menuid = menuId.value, column = column, menutext = "Hi there") }
            }

            @ParameterizedTest
            @ValueSource(ints = [-1, 2])
            fun givenInvalidColumnItShouldThrowException(column: Int) {
                val caughtThrowable = catchThrowable { menu.addItem(column, "Hi there") }

                assertThat(caughtThrowable)
                        .isInstanceOf(IllegalArgumentException::class.java)
            }

            @Test
            fun givenFormattedTextItShouldAddMenuItem() {
                every { nativeFunctionExecutor.addMenuItem(any(), any(), any()) } returns 0
                every { textFormatter.format(locale, "Hi %s", "there") } returns "Hi there"

                menu.addItem(0, "Hi %s", "there")

                verify { nativeFunctionExecutor.addMenuItem(menuid = menuId.value, column = 0, menutext = "Hi there") }
            }

            @Test
            fun givenProvidedTextItShouldAddMenuItem() {
                every { nativeFunctionExecutor.addMenuItem(any(), any(), any()) } returns 0
                val textKey = TextKey("test")
                every { textProvider.getText(locale, textKey) } returns "Hi there"

                menu.addItem(0, textKey)

                verify { nativeFunctionExecutor.addMenuItem(menuid = menuId.value, column = 0, menutext = "Hi there") }
            }

            @Test
            fun givenFormattedProvidedTextItShouldAddMenuItem() {
                every { nativeFunctionExecutor.addMenuItem(any(), any(), any()) } returns 0
                val textKey = TextKey("test")
                every { textProvider.getText(locale, textKey) } returns "Hi %s"
                every { textFormatter.format(locale, "Hi %s", "there") } returns "Hi there"

                menu.addItem(0, textKey, "there")

                verify { nativeFunctionExecutor.addMenuItem(menuid = menuId.value, column = 0, menutext = "Hi there") }
            }

            @ParameterizedTest
            @ValueSource(ints = [0, 1])
            fun givenNoRowItShouldAddItemAsNewRow(column: Int) {
                every { nativeFunctionExecutor.addMenuItem(any(), any(), any()) } returns 0

                val menuRow = menu.addItem(column, "Hi there")

                assertThat(menuRow)
                        .satisfies {
                            assertThat(it.menu)
                                    .isEqualTo(menu)
                            assertThat(it.index)
                                    .isEqualTo(0)
                            assertThat(it.getText(column))
                                    .isEqualTo("Hi there")
                        }
                assertThat(menu.rows)
                        .containsExactlyInAnyOrder(menuRow)
            }

            @Test
            fun givenItemIsAddedToExistingRowItShouldSetTheText() {
                every { nativeFunctionExecutor.addMenuItem(any(), any(), any()) } returns 0
                menu.addItem(0, "Hi there")

                val menuRow = menu.addItem(1, "How ya doing")

                assertThat(menuRow)
                        .satisfies {
                            assertThat(it.menu)
                                    .isEqualTo(menu)
                            assertThat(it.index)
                                    .isEqualTo(0)
                            assertThat(it.getText(0))
                                    .isEqualTo("Hi there")
                            assertThat(it.getText(1))
                                    .isEqualTo("How ya doing")
                        }
                assertThat(menu.rows)
                        .containsExactlyInAnyOrder(menuRow)
            }

            @Test
            fun shouldAddItemToNewRow() {
                every { nativeFunctionExecutor.addMenuItem(any(), any(), any()) } returnsMany listOf(0, 1)
                val existingMenuRow = menu.addItem(0, "Hi there")

                val newMenuRow = menu.addItem(0, "How ya doing")

                assertThat(existingMenuRow)
                        .satisfies {
                            assertThat(it.menu)
                                    .isEqualTo(menu)
                            assertThat(it.index)
                                    .isEqualTo(0)
                            assertThat(it.getText(0))
                                    .isEqualTo("Hi there")
                            assertThat(it.getText(1))
                                    .isNull()
                        }
                assertThat(newMenuRow)
                        .satisfies {
                            assertThat(it.menu)
                                    .isEqualTo(menu)
                            assertThat(it.index)
                                    .isEqualTo(1)
                            assertThat(it.getText(0))
                                    .isEqualTo("How ya doing")
                            assertThat(it.getText(1))
                                    .isNull()
                        }
                assertThat(menu.rows)
                        .containsExactly(existingMenuRow, newMenuRow)
            }
        }

        @Nested
        inner class SetColumnHeaderTests {

            @BeforeEach
            fun setUp() {
                every { nativeFunctionExecutor.setMenuColumnHeader(any(), any(), any()) } returns true
            }

            @ParameterizedTest
            @ValueSource(ints = [0, 1])
            fun shouldSetColumnHeader(column: Int) {
                menu.setColumnHeader(column, "Hi there")

                verify {
                    nativeFunctionExecutor.setMenuColumnHeader(
                            menuid = menuId.value,
                            column = column,
                            columnheader = "Hi there"
                    )
                }
            }

            @ParameterizedTest
            @ValueSource(ints = [-1, 2])
            fun givenInvalidColumnItShouldThrowException(column: Int) {
                val caughtThrowable = catchThrowable { menu.setColumnHeader(column, "Hi there") }

                assertThat(caughtThrowable)
                        .isInstanceOf(IllegalArgumentException::class.java)
            }

            @Test
            fun givenFormattedTextItShouldSetColumnHeader() {
                every { textFormatter.format(locale, "Hi %s", "there") } returns "Hi there"

                menu.setColumnHeader(0, "Hi %s", "there")

                verify {
                    nativeFunctionExecutor.setMenuColumnHeader(
                            menuid = menuId.value,
                            column = 0,
                            columnheader = "Hi there"
                    )
                }
            }

            @Test
            fun givenProvidedTextItShouldSetColumnHeader() {
                val textKey = TextKey("test")
                every { textProvider.getText(locale, textKey) } returns "Hi there"

                menu.setColumnHeader(0, textKey)

                verify {
                    nativeFunctionExecutor.setMenuColumnHeader(
                            menuid = menuId.value,
                            column = 0,
                            columnheader = "Hi there"
                    )
                }
            }

            @Test
            fun givenFormattedProvidedTextItShouldSetColumnHeader() {
                val textKey = TextKey("test")
                every { textProvider.getText(locale, textKey) } returns "Hi %s"
                every { textFormatter.format(locale, "Hi %s", "there") } returns "Hi there"

                menu.setColumnHeader(0, textKey, "there")

                verify {
                    nativeFunctionExecutor.setMenuColumnHeader(
                            menuid = menuId.value,
                            column = 0,
                            columnheader = "Hi there"
                    )
                }
            }
        }

        @Test
        fun shouldDisableMenu() {
            every { nativeFunctionExecutor.disableMenu(any()) } returns true

            menu.disable()

            verify { nativeFunctionExecutor.disableMenu(menuId.value) }
        }

        @Test
        fun shouldShowForPlayer() {
            val player = mockk<Player> {
                every { id } returns PlayerId.valueOf(69)
            }
            every { nativeFunctionExecutor.showMenuForPlayer(any(), any()) } returns true

            menu.show(player)

            verify { nativeFunctionExecutor.showMenuForPlayer(menuid = menuId.value, playerid = 69) }
        }

        @Test
        fun shouldHideForPlayer() {
            val player = mockk<Player> {
                every { id } returns PlayerId.valueOf(69)
            }
            every { nativeFunctionExecutor.hideMenuForPlayer(any(), any()) } returns true

            menu.hide(player)

            verify { nativeFunctionExecutor.hideMenuForPlayer(menuid = menuId.value, playerid = 69) }
        }

        @Test
        fun shouldExecuteOnExitHandlers() {
            val player = mockk<Player>()
            val onExit = mockk<Menu.(Player) -> Unit>(relaxed = true)
            menu.onExit(onExit)

            menu.onExit(player)

            verify { onExit.invoke(menu, player) }
        }

        @Nested
        inner class OnSelectedMenuRowTests {

            @Test
            fun shouldExecuteOnSelectedMenuRowHandlers() {
                every { nativeFunctionExecutor.addMenuItem(any(), any(), any()) } returns 0
                val menuRow = menu.addItem(0, "Hi there")
                val player = mockk<Player>()
                val onSelectedMenuRow = mockk<Menu.(Player, MenuRow) -> Unit>(relaxed = true)
                menu.onSelectedMenuRow(onSelectedMenuRow)

                menu.onSelectedMenuRow(player = player, rowIndex = 0)

                verify { onSelectedMenuRow.invoke(menu, player, menuRow) }
            }

            @Test
            fun shouldExecuteMenuRowOnSelectedHandlers() {
                every { nativeFunctionExecutor.addMenuItem(any(), any(), any()) } returns 0
                val menuRow = menu.addItem(0, "Hi there")
                val player = mockk<Player>()
                val onSelected = mockk<MenuRow.(Player) -> Unit>(relaxed = true)
                menuRow.onSelected(onSelected)

                menu.onSelectedMenuRow(player = player, rowIndex = 0)

                verify { onSelected.invoke(menuRow, player) }
            }

        }


        @Nested
        inner class DestroyTests {

            @BeforeEach
            fun setUp() {
                every { nativeFunctionExecutor.destroyMenu(any()) } returns true
            }

            @Test
            fun isDestroyedShouldInitiallyBeFalse() {
                val isDestroyed = menu.isDestroyed

                assertThat(isDestroyed)
                        .isFalse()
            }

            @Test
            fun shouldDestroyMenu() {
                val onDestroy = mockk<MenuImpl.() -> Unit>(relaxed = true)
                menu.onDestroy(onDestroy)

                menu.destroy()

                verifyOrder {
                    onDestroy.invoke(menu)
                    nativeFunctionExecutor.destroyMenu(menuId.value)
                }
                assertThat(menu.isDestroyed)
                        .isTrue()
            }

            @Test
            fun shouldNotExecuteDestroyTwice() {
                val onDestroy = mockk<MenuImpl.() -> Unit>(relaxed = true)
                menu.onDestroy(onDestroy)

                menu.destroy()
                menu.destroy()

                verify(exactly = 1) {
                    nativeFunctionExecutor.destroyMenu(menuId.value)
                    onDestroy.invoke(menu)
                }
            }

            @Test
            fun givenItDestroyedIdShouldThrowException() {
                menu.destroy()

                val caughtThrowable = catchThrowable { menu.id }

                assertThat(caughtThrowable)
                        .isInstanceOf(AlreadyDestroyedException::class.java)
            }
        }
    }

}
package ch.leadrian.samp.kamp.runtime.entity

import ch.leadrian.samp.kamp.api.constants.ObjectEditResponse
import ch.leadrian.samp.kamp.api.constants.ObjectMaterialSize
import ch.leadrian.samp.kamp.api.constants.ObjectMaterialTextAlignment
import ch.leadrian.samp.kamp.api.constants.SAMPConstants
import ch.leadrian.samp.kamp.api.data.Colors
import ch.leadrian.samp.kamp.api.data.Vector3D
import ch.leadrian.samp.kamp.api.data.vector3DOf
import ch.leadrian.samp.kamp.api.entity.Player
import ch.leadrian.samp.kamp.api.entity.PlayerMapObject
import ch.leadrian.samp.kamp.api.entity.Vehicle
import ch.leadrian.samp.kamp.api.entity.id.PlayerId
import ch.leadrian.samp.kamp.api.entity.id.PlayerMapObjectId
import ch.leadrian.samp.kamp.api.entity.id.VehicleId
import ch.leadrian.samp.kamp.api.exception.AlreadyDestroyedException
import ch.leadrian.samp.kamp.api.exception.CreationFailedException
import ch.leadrian.samp.kamp.runtime.SAMPNativeFunctionExecutor
import ch.leadrian.samp.kamp.runtime.types.ReferenceFloat
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

internal class PlayerMapObjectImplTest {

    private val playerId = PlayerId.valueOf(69)
    private val player = mockk<Player>()

    @BeforeEach
    fun setUp() {
        every { player.id } returns playerId
    }

    @Nested
    inner class ConstructorTests {

        @Test
        fun shouldConstructPlayerMapObject() {
            val playerMapObjectId = PlayerMapObjectId.valueOf(69)
            val nativeFunctionExecutor = mockk<SAMPNativeFunctionExecutor> {
                every {
                    createPlayerObject(
                            playerid = playerId.value,
                            modelid = 1337,
                            x = 1f,
                            y = 2f,
                            z = 3f,
                            rX = 4f,
                            rY = 5f,
                            rZ = 6f,
                            DrawDistance = 7f
                    )
                } returns playerMapObjectId.value
            }

            val playerMapObject = PlayerMapObjectImpl(
                    player = player,
                    model = 1337,
                    coordinates = vector3DOf(x = 1f, y = 2f, z = 3f),
                    rotation = vector3DOf(x = 4f, y = 5f, z = 6f),
                    drawDistance = 7f,
                    nativeFunctionExecutor = nativeFunctionExecutor
            )

            assertThat(playerMapObject.id)
                    .isEqualTo(playerMapObjectId)
        }

        @Test
        fun givenCreatePlayerMapObjectReturnsInvalidPlayerMapObjectIdItShouldThrowCreationFailedException() {
            val nativeFunctionExecutor = mockk<SAMPNativeFunctionExecutor> {
                every {
                    createPlayerObject(
                            playerid = playerId.value,
                            modelid = 1337,
                            x = 1f,
                            y = 2f,
                            z = 3f,
                            rX = 4f,
                            rY = 5f,
                            rZ = 6f,
                            DrawDistance = 7f
                    )
                } returns SAMPConstants.INVALID_OBJECT_ID
            }

            val caughtThrowable = catchThrowable {
                PlayerMapObjectImpl(
                        player = player,
                        model = 1337,
                        coordinates = vector3DOf(x = 1f, y = 2f, z = 3f),
                        rotation = vector3DOf(x = 4f, y = 5f, z = 6f),
                        drawDistance = 7f,
                        nativeFunctionExecutor = nativeFunctionExecutor
                )
            }

            assertThat(caughtThrowable)
                    .isInstanceOf(CreationFailedException::class.java)
        }
    }

    @Nested
    inner class PostConstructionTests {

        private val playerMapObjectId = PlayerMapObjectId.valueOf(50)
        private lateinit var playerMapObject: PlayerMapObjectImpl

        private val nativeFunctionExecutor = mockk<SAMPNativeFunctionExecutor>()

        @BeforeEach
        fun setUp() {
            every {
                nativeFunctionExecutor.createPlayerObject(any(), any(), any(), any(), any(), any(), any(), any(), any())
            } returns playerMapObjectId.value
            playerMapObject = PlayerMapObjectImpl(
                    player = player,
                    model = 1337,
                    coordinates = vector3DOf(x = 1f, y = 2f, z = 3f),
                    rotation = vector3DOf(x = 4f, y = 5f, z = 6f),
                    drawDistance = 7f,
                    nativeFunctionExecutor = nativeFunctionExecutor
            )
        }

        @Test
        fun shouldAttachToPlayer() {
            every {
                nativeFunctionExecutor.attachPlayerObjectToPlayer(any(), any(), any(), any(), any(), any(), any(), any(), any())
            } returns true
            val otherPlayer = mockk<Player> {
                every { id } returns PlayerId.valueOf(69)
            }

            playerMapObject.attachTo(
                    player = otherPlayer,
                    offset = vector3DOf(x = 1f, y = 2f, z = 3f),
                    rotation = vector3DOf(x = 4f, y = 5f, z = 6f)
            )

            verify {
                nativeFunctionExecutor.attachPlayerObjectToPlayer(
                        objectplayer = playerId.value,
                        objectid = playerMapObjectId.value,
                        attachplayer = 69,
                        OffsetX = 1f,
                        OffsetY = 2f,
                        OffsetZ = 3f,
                        rX = 4f,
                        rY = 5f,
                        rZ = 6f
                )
            }
        }

        @Test
        fun shouldAttachToVehicle() {
            every {
                nativeFunctionExecutor.attachPlayerObjectToVehicle(any(), any(), any(), any(), any(), any(), any(), any(), any())
            } returns true
            val vehicle = mockk<Vehicle> {
                every { id } returns VehicleId.valueOf(69)
            }

            playerMapObject.attachTo(
                    vehicle = vehicle,
                    offset = vector3DOf(x = 1f, y = 2f, z = 3f),
                    rotation = vector3DOf(x = 4f, y = 5f, z = 6f)
            )

            verify {
                nativeFunctionExecutor.attachPlayerObjectToVehicle(
                        playerid = playerId.value,
                        objectid = playerMapObjectId.value,
                        vehicleid = 69,
                        fOffsetX = 1f,
                        fOffsetY = 2f,
                        fOffsetZ = 3f,
                        fRotX = 4f,
                        fRotY = 5f,
                        RotZ = 6f
                )
            }
        }

        @Nested
        inner class CoordinatesTests {

            @Test
            fun shouldGetCoordinates() {
                every {
                    nativeFunctionExecutor.getPlayerObjectPos(
                            playerid = playerId.value,
                            objectid = playerMapObjectId.value,
                            x = any(),
                            y = any(),
                            z = any()
                    )
                } answers {
                    thirdArg<ReferenceFloat>().value = 1f
                    arg<ReferenceFloat>(3).value = 2f
                    arg<ReferenceFloat>(4).value = 3f
                    true
                }

                val coordinates = playerMapObject.coordinates

                assertThat(coordinates)
                        .isEqualTo(vector3DOf(x = 1f, y = 2f, z = 3f))
            }

            @Test
            fun shouldSetCoordinates() {
                every { nativeFunctionExecutor.setPlayerObjectPos(any(), any(), any(), any(), any()) } returns true

                playerMapObject.coordinates = vector3DOf(x = 1f, y = 2f, z = 3f)

                verify {
                    nativeFunctionExecutor.setPlayerObjectPos(
                            playerid = playerId.value,
                            objectid = playerMapObjectId.value,
                            x = 1f,
                            y = 2f,
                            z = 3f
                    )
                }
            }
        }

        @Nested
        inner class RotationTests {

            @Test
            fun shouldGetRotation() {
                every {
                    nativeFunctionExecutor.getPlayerObjectRot(
                            playerid = playerId.value,
                            objectid = playerMapObjectId.value,
                            rotX = any(),
                            rotY = any(),
                            rotZ = any()
                    )
                } answers {
                    thirdArg<ReferenceFloat>().value = 1f
                    arg<ReferenceFloat>(3).value = 2f
                    arg<ReferenceFloat>(4).value = 3f
                    true
                }

                val rotation = playerMapObject.rotation

                assertThat(rotation)
                        .isEqualTo(vector3DOf(x = 1f, y = 2f, z = 3f))
            }

            @Test
            fun shouldSetRotation() {
                every { nativeFunctionExecutor.setPlayerObjectRot(any(), any(), any(), any(), any()) } returns true

                playerMapObject.rotation = vector3DOf(x = 1f, y = 2f, z = 3f)

                verify {
                    nativeFunctionExecutor.setPlayerObjectRot(
                            playerid = playerId.value,
                            objectid = playerMapObjectId.value,
                            rotX = 1f,
                            rotY = 2f,
                            rotZ = 3f
                    )
                }
            }
        }

        @Test
        fun shouldDisableCameraCollisions() {
            every { nativeFunctionExecutor.setPlayerObjectNoCameraCol(any(), any()) } returns true

            playerMapObject.disableCameraCollision()

            verify {
                nativeFunctionExecutor.setPlayerObjectNoCameraCol(
                        playerid = playerId.value,
                        objectid = playerMapObjectId.value
                )
            }
        }

        @Test
        fun shouldMovePlayerObject() {
            every {
                nativeFunctionExecutor.movePlayerObject(
                        playerid = playerId.value,
                        objectid = playerMapObjectId.value,
                        x = 1f,
                        y = 2f,
                        z = 3f,
                        RotX = 4f,
                        RotY = 5f,
                        RotZ = 6f,
                        Speed = 7f
                )
            } returns 150

            val result = playerMapObject.moveTo(
                    coordinates = vector3DOf(x = 1f, y = 2f, z = 3f),
                    rotation = vector3DOf(x = 4f, y = 5f, z = 6f),
                    speed = 7f
            )

            assertThat(result)
                    .isEqualTo(150)
        }

        @Test
        fun shouldStopPlayerObject() {
            every { nativeFunctionExecutor.stopPlayerObject(any(), any()) } returns true

            playerMapObject.stop()

            verify {
                nativeFunctionExecutor.stopPlayerObject(
                        playerid = playerId.value,
                        objectid = playerMapObjectId.value
                )
            }
        }

        @ParameterizedTest
        @ValueSource(strings = ["true", "false"])
        fun isMovingShouldReturnExpectedValue(expectedResult: Boolean) {
            every {
                nativeFunctionExecutor.isPlayerObjectMoving(
                        playerid = playerId.value,
                        objectid = playerMapObjectId.value
                )
            } returns expectedResult

            val result = playerMapObject.isMoving

            assertThat(result)
                    .isEqualTo(expectedResult)
        }

        @Test
        fun shouldSetMaterial() {
            every {
                nativeFunctionExecutor.setPlayerObjectMaterial(any(), any(), any(), any(), any(), any(), any())
            } returns true

            playerMapObject.setMaterial(
                    index = 187,
                    modelId = 1337,
                    color = Colors.RED,
                    textureName = "texture A",
                    txdName = "txd A"
            )

            verify {
                nativeFunctionExecutor.setPlayerObjectMaterial(
                        playerid = playerId.value,
                        objectid = playerMapObjectId.value,
                        materialindex = 187,
                        modelid = 1337,
                        materialcolor = Colors.RED.value,
                        texturename = "texture A",
                        txdname = "txd A"
                )
            }
        }

        @ParameterizedTest
        @ValueSource(strings = ["true", "false"])
        fun shouldSetMaterialText(isBold: Boolean) {
            every {
                nativeFunctionExecutor.setPlayerObjectMaterialText(any(), any(), any(), any(), any(), any(), any(), any(), any(), any(), any())
            } returns true

            playerMapObject.setMaterialText(
                    text = "hi",
                    index = 187,
                    size = ObjectMaterialSize.SIZE_256X128,
                    fontSize = 16,
                    textAlignment = ObjectMaterialTextAlignment.CENTER,
                    fontFace = "Comic Sans",
                    isBold = isBold,
                    fontColor = Colors.BLUE,
                    backColor = Colors.AQUA
            )

            verify {
                nativeFunctionExecutor.setPlayerObjectMaterialText(
                        playerid = playerId.value,
                        objectid = playerMapObjectId.value,
                        text = "hi",
                        materialindex = 187,
                        materialsize = ObjectMaterialSize.SIZE_256X128.value,
                        fontsize = 16,
                        textalignment = ObjectMaterialTextAlignment.CENTER.value,
                        fontface = "Comic Sans",
                        bold = isBold,
                        fontcolor = Colors.BLUE.value,
                        backcolor = Colors.AQUA.value
                )
            }
        }

        @Test
        fun shouldExecuteOnMovedHandlers() {
            val onMoved = mockk<PlayerMapObject.() -> Unit>(relaxed = true)
            playerMapObject.onMoved(onMoved)

            playerMapObject.onMoved()

            verify { onMoved.invoke(playerMapObject) }
        }

        @Test
        fun shouldExecuteOnEditHandlers() {
            val onEdit = mockk<PlayerMapObject.(ObjectEditResponse, Vector3D, Vector3D) -> Unit>(relaxed = true)
            playerMapObject.onEdit(onEdit)

            playerMapObject.onEdit(
                    response = ObjectEditResponse.UPDATE,
                    offset = vector3DOf(x = 1f, y = 2f, z = 3f),
                    rotation = vector3DOf(x = 4f, y = 5f, z = 6f)
            )

            verify {
                onEdit.invoke(
                        playerMapObject,
                        ObjectEditResponse.UPDATE,
                        vector3DOf(x = 1f, y = 2f, z = 3f),
                        vector3DOf(x = 4f, y = 5f, z = 6f)
                )
            }
        }

        @Nested
        inner class DestroyTests {

            @BeforeEach
            fun setUp() {
                every { nativeFunctionExecutor.destroyPlayerObject(any(), any()) } returns true
            }

            @Test
            fun isDestroyedShouldInitiallyBeFalse() {
                val isDestroyed = playerMapObject.isDestroyed

                assertThat(isDestroyed)
                        .isFalse()
            }

            @Test
            fun shouldDestroyPlayerMapObject() {
                val onDestroy = mockk<PlayerMapObjectImpl.() -> Unit>(relaxed = true)
                playerMapObject.onDestroy(onDestroy)

                playerMapObject.destroy()

                verifyOrder {
                    onDestroy.invoke(playerMapObject)
                    nativeFunctionExecutor.destroyPlayerObject(
                            playerid = playerId.value,
                            objectid = playerMapObjectId.value
                    )
                }
                assertThat(playerMapObject.isDestroyed)
                        .isTrue()
            }

            @Test
            fun shouldNotExecuteDestroyTwice() {
                val onDestroy = mockk<PlayerMapObjectImpl.() -> Unit>(relaxed = true)
                playerMapObject.onDestroy(onDestroy)

                playerMapObject.destroy()
                playerMapObject.destroy()

                verify(exactly = 1) {
                    nativeFunctionExecutor.destroyPlayerObject(
                            playerid = playerId.value,
                            objectid = playerMapObjectId.value
                    )
                    onDestroy.invoke(playerMapObject)
                }
            }

            @Test
            fun givenItDestroyedIdShouldThrowException() {
                playerMapObject.destroy()

                val caughtThrowable = catchThrowable { playerMapObject.id }

                assertThat(caughtThrowable)
                        .isInstanceOf(AlreadyDestroyedException::class.java)
            }
        }
    }
}
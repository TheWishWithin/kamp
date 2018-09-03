package ch.leadrian.samp.kamp.runtime.entity.factory

import ch.leadrian.samp.kamp.api.entity.id.PlayerId
import ch.leadrian.samp.kamp.runtime.SAMPNativeFunctionExecutor
import ch.leadrian.samp.kamp.runtime.entity.registry.ActorRegistry
import ch.leadrian.samp.kamp.runtime.entity.registry.MapObjectRegistry
import ch.leadrian.samp.kamp.runtime.entity.registry.MenuRegistry
import ch.leadrian.samp.kamp.runtime.entity.registry.PlayerRegistry
import ch.leadrian.samp.kamp.runtime.entity.registry.VehicleRegistry
import io.mockk.Runs
import io.mockk.every
import io.mockk.just
import io.mockk.mockk
import io.mockk.verify
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class PlayerFactoryTest {

    private val playerId = PlayerId.valueOf(123)
    private lateinit var playerFactory: PlayerFactory

    private val nativeFunctionExecutor = mockk<SAMPNativeFunctionExecutor>()
    private val playerRegistry = mockk<PlayerRegistry>()
    private val actorRegistry = mockk<ActorRegistry>()
    private val mapObjectRegistry = mockk<MapObjectRegistry>()
    private val menuRegistry = mockk<MenuRegistry>()
    private val playerMapIconFactory = mockk<PlayerMapIconFactory>()
    private val vehicleRegistry = mockk<VehicleRegistry>()

    @BeforeEach
    fun setUp() {
        every { playerRegistry.register(any()) } just Runs
        playerFactory = PlayerFactory(
                actorRegistry = actorRegistry,
                playerRegistry = playerRegistry,
                mapObjectRegistry = mapObjectRegistry,
                menuRegistry = menuRegistry,
                playerMapIconFactory = playerMapIconFactory,
                vehicleRegistry = vehicleRegistry,
                nativeFunctionExecutor = nativeFunctionExecutor
        )
    }

    @Test
    fun shouldReturnPlayer() {
        val player = playerFactory.create(playerId)

        assertThat(player.id)
                .isEqualTo(playerId)
    }

    @Test
    fun shouldRegisterPlayer() {
        val player = playerFactory.create(playerId)

        verify { playerRegistry.register(player) }
    }

}
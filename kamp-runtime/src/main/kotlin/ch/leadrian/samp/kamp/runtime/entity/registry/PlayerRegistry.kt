package ch.leadrian.samp.kamp.runtime.entity.registry

import ch.leadrian.samp.kamp.api.entity.Player
import ch.leadrian.samp.kamp.runtime.SAMPNativeFunctionExecutor
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
internal class PlayerRegistry
@Inject
constructor(nativeFunctionExecutor: SAMPNativeFunctionExecutor) {

    private val players: Array<Player?> = arrayOfNulls(nativeFunctionExecutor.getMaxPlayers())

    fun register(player: Player) {
        if (players[player.id.value] != null) {
            throw IllegalStateException("There is already a player with ID ${player.id.value} registered")
        }
        players[player.id.value] = player
    }

    fun unregister(player: Player) {
        if (players[player.id.value] !== player) {
            throw IllegalStateException("Trying to unregister player with ID ${player.id.value} that is not registered")
        }
        players[player.id.value] = null
    }

    fun getPlayer(playerId: Int): Player? =
            when (playerId) {
                in (0 until players.size) -> players[playerId]
                else -> null
            }

    fun getAllPlayers(): List<Player> = players.filterNotNull()

}
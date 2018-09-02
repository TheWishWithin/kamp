package ch.leadrian.samp.kamp.runtime.entity

import ch.leadrian.samp.kamp.api.data.Vector3D
import ch.leadrian.samp.kamp.api.entity.Checkpoint
import ch.leadrian.samp.kamp.api.entity.Player
import ch.leadrian.samp.kamp.runtime.entity.registry.PlayerRegistry

internal class CheckpointImpl(
        coordinates: Vector3D,
        size: Float,
        private val playerRegistry: PlayerRegistry
) : Checkpoint {

    private val onEnterHandlers: MutableList<Checkpoint.(Player) -> Unit> = mutableListOf()

    private val onLeaveHandlers: MutableList<Checkpoint.(Player) -> Unit> = mutableListOf()

    override var coordinates: Vector3D = coordinates.toVector3D()
        set(value) {
            field = value.toVector3D()
            update()
        }

    override var size: Float = size
        set(value) {
            field = value
            update()
        }

    private fun update() {
        playerRegistry.getAllPlayers().filter { it.checkpoint === this }.forEach {
            it.checkpoint = this
        }
    }

    override fun onEnter(onEnter: Checkpoint.(Player) -> Unit) {
        onEnterHandlers += onEnter
    }

    internal fun onEnter(player: Player) {
        onEnterHandlers.forEach { it.invoke(this, player) }
    }

    override fun onLeave(onLeave: Checkpoint.(Player) -> Unit) {
        onLeaveHandlers += onLeave
    }

    internal fun onLeave(player: Player) {
        onLeaveHandlers.forEach { it.invoke(this, player) }
    }

    override var isDestroyed: Boolean = false
        private set

    override fun destroy() {
        if (isDestroyed) return

        playerRegistry.getAllPlayers().forEach {
            if (it.isInCheckpoint(this)) {
                onLeave(it)
                it.checkpoint = null
            }
        }
        isDestroyed = true
    }
}
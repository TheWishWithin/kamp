package ch.leadrian.samp.kamp.core.api.entity

import ch.leadrian.samp.kamp.core.api.constants.SAMPConstants
import ch.leadrian.samp.kamp.core.api.data.Color
import ch.leadrian.samp.kamp.core.api.data.Vector3D
import ch.leadrian.samp.kamp.core.api.entity.id.PlayerTextLabelId
import ch.leadrian.samp.kamp.core.api.exception.CreationFailedException
import ch.leadrian.samp.kamp.core.runtime.SAMPNativeFunctionExecutor

class PlayerTextLabel
internal constructor(
        coordinates: Vector3D,
        text: String,
        color: Color,
        override val drawDistance: Float,
        override val testLOS: Boolean,
        override val player: Player,
        private val nativeFunctionExecutor: SAMPNativeFunctionExecutor,
        attachToPlayer: Player?,
        attachToVehicle: Vehicle?
) : Entity<PlayerTextLabelId>, HasPlayer, AbstractDestroyable(), TextLabelBase {

    override val id: PlayerTextLabelId
        get() = requireNotDestroyed { field }

    private var _text: String = text

    override var text: String
        get() = _text
        set(value) {
            update(value, _color)
        }

    private var _color: Color = color.toColor()

    override var color: Color
        get() = _color
        set(value) {
            update(_text, value)
        }

    override val coordinates: Vector3D = coordinates.toVector3D()

    override var isDestroyed: Boolean = false
        get() = field || !player.isConnected

    init {
        val playerTextLabelId = nativeFunctionExecutor.createPlayer3DTextLabel(
                playerid = player.id.value,
                DrawDistance = drawDistance,
                testLOS = testLOS,
                color = color.value,
                text = text,
                x = coordinates.x,
                y = coordinates.y,
                z = coordinates.z,
                attachedplayer = attachToPlayer?.id?.value ?: SAMPConstants.INVALID_PLAYER_ID,
                attachedvehicle = attachToVehicle?.id?.value ?: SAMPConstants.INVALID_VEHICLE_ID
        )

        if (playerTextLabelId == SAMPConstants.INVALID_3DTEXT_ID) {
            throw CreationFailedException("Failed to create player 3D text label")
        }

        id = PlayerTextLabelId.valueOf(playerTextLabelId)
    }

    override fun update(text: String, color: Color) {
        nativeFunctionExecutor.updatePlayer3DTextLabelText(
                playerid = player.id.value,
                id = id.value,
                text = text,
                color = color.value
        )
        _color = color
        _text = text
    }

    override fun onDestroy() {
        nativeFunctionExecutor.deletePlayer3DTextLabel(playerid = player.id.value, id = id.value)
    }
}
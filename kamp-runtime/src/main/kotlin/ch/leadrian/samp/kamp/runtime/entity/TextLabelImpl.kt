package ch.leadrian.samp.kamp.runtime.entity

import ch.leadrian.samp.kamp.api.constants.SAMPConstants
import ch.leadrian.samp.kamp.api.data.Color
import ch.leadrian.samp.kamp.api.data.Vector3D
import ch.leadrian.samp.kamp.api.entity.Player
import ch.leadrian.samp.kamp.api.entity.TextLabel
import ch.leadrian.samp.kamp.api.entity.Vehicle
import ch.leadrian.samp.kamp.api.entity.id.TextLabelId
import ch.leadrian.samp.kamp.api.entity.requireNotDestroyed
import ch.leadrian.samp.kamp.api.exception.CreationFailedException
import ch.leadrian.samp.kamp.runtime.SAMPNativeFunctionExecutor

internal class TextLabelImpl(
        coordinates: Vector3D,
        text: String,
        color: Color,
        override val virtualWorldId: Int,
        override val drawDistance: Float,
        override val testLOS: Boolean,
        private val nativeFunctionExecutor: SAMPNativeFunctionExecutor
) : TextLabel {

    private val onDestroyHandlers: MutableList<TextLabelImpl.() -> Unit> = mutableListOf()

    override val id: TextLabelId
        get() = requireNotDestroyed { field }

    init {
        val textLabelId = nativeFunctionExecutor.create3DTextLabel(
                DrawDistance = drawDistance,
                testLOS = testLOS,
                color = color.value,
                text = text,
                x = coordinates.x,
                y = coordinates.y,
                z = coordinates.z,
                virtualworld = virtualWorldId
        )

        if (textLabelId == SAMPConstants.INVALID_3DTEXT_ID) {
            throw CreationFailedException("Failed to create player 3D text label")
        }

        id = TextLabelId.valueOf(textLabelId)
    }

    private var _text: String = text

    override var text: String
        get() = _text
        set(value) {
            nativeFunctionExecutor.update3DTextLabelText(
                    id = id.value,
                    text = value,
                    color = _color.value
            )
            _text = value
        }

    private var _color: Color = color.toColor()

    override var color: Color
        get() = _color
        set(value) {
            nativeFunctionExecutor.update3DTextLabelText(
                    id = id.value,
                    text = _text,
                    color = value.value
            )
            _color = value
        }

    override val coordinates: Vector3D = coordinates.toVector3D()

    override fun update(text: String, color: Color) {
        nativeFunctionExecutor.update3DTextLabelText(
                id = id.value,
                text = text,
                color = color.value
        )
        _color = color
        _text = text
    }

    override fun attachTo(player: Player, offset: Vector3D) {
        nativeFunctionExecutor.attach3DTextLabelToPlayer(
                id = id.value,
                playerid = player.id.value,
                OffsetX = offset.x,
                OffsetY = offset.y,
                OffsetZ = offset.z
        )
    }

    override fun attachTo(vehicle: Vehicle, offset: Vector3D) {
        nativeFunctionExecutor.attach3DTextLabelToVehicle(
                id = id.value,
                vehicleid = vehicle.id.value,
                OffsetX = offset.x,
                OffsetY = offset.y,
                OffsetZ = offset.z
        )
    }

    internal fun onDestroy(onDestroy: TextLabelImpl.() -> Unit) {
        onDestroyHandlers += onDestroy
    }

    override var isDestroyed: Boolean = false
        private set

    override fun destroy() {
        if (isDestroyed) return

        onDestroyHandlers.forEach { it.invoke(this) }
        nativeFunctionExecutor.delete3DTextLabel(id.value)
        isDestroyed = true
    }
}
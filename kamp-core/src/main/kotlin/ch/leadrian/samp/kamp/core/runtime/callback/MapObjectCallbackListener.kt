package ch.leadrian.samp.kamp.core.runtime.callback

import ch.leadrian.samp.kamp.core.api.callback.CallbackListenerManager
import ch.leadrian.samp.kamp.core.api.callback.OnMapObjectMovedListener
import ch.leadrian.samp.kamp.core.api.callback.OnPlayerEditMapObjectListener
import ch.leadrian.samp.kamp.core.api.callback.OnPlayerSelectMapObjectListener
import ch.leadrian.samp.kamp.core.api.constants.ObjectEditResponse
import ch.leadrian.samp.kamp.core.api.data.Vector3D
import ch.leadrian.samp.kamp.core.api.entity.MapObject
import ch.leadrian.samp.kamp.core.api.entity.Player
import javax.annotation.PostConstruct
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
internal class MapObjectCallbackListener
@Inject
constructor(
        private val callbackListenerManager: CallbackListenerManager
) : OnMapObjectMovedListener, OnPlayerEditMapObjectListener, OnPlayerSelectMapObjectListener {

    @PostConstruct
    fun initialize() {
        callbackListenerManager.register(this)
    }

    override fun onPlayerEditMapObject(
            player: Player,
            mapObject: MapObject,
            response: ObjectEditResponse,
            offset: Vector3D,
            rotation: Vector3D
    ) {
        mapObject.onEdit(player = player, response = response, offset = offset, rotation = rotation)
    }

    override fun onMapObjectMoved(mapObject: MapObject) {
        mapObject.onMoved()
    }

    override fun onPlayerSelectMapObject(player: Player, mapObject: MapObject, modelId: Int, coordinates: Vector3D) {
        mapObject.onSelect(player, modelId, coordinates)
    }

}
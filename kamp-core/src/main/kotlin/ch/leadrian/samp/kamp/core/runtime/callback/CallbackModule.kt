package ch.leadrian.samp.kamp.core.runtime.callback

import ch.leadrian.samp.kamp.core.api.callback.CallbackListenerManager
import ch.leadrian.samp.kamp.core.api.inject.KampModule

internal class CallbackModule : KampModule() {

    override fun configure() {
        bind(ActorCallbackListener::class.java).asEagerSingleton()
        bind(CheckpointCallbackListener::class.java).asEagerSingleton()
        bind(DialogCallbackListener::class.java).asEagerSingleton()
        bind(MenuCallbackListener::class.java).asEagerSingleton()
        bind(MapObjectCallbackListener::class.java).asEagerSingleton()
        bind(PickupCallbackListener::class.java).asEagerSingleton()
        bind(PlayerMapObjectCallbackListener::class.java).asEagerSingleton()
        bind(RaceCheckpointCallbackListener::class.java).asEagerSingleton()
        bind(TextDrawCallbackListener::class.java).asEagerSingleton()
        bind(PlayerTextDrawCallbackListener::class.java).asEagerSingleton()
        bind(VehicleCallbackListener::class.java).asEagerSingleton()

        bind(CallbackProcessor::class.java)
        bind(CallbackListenerManager::class.java)

        bind(OnActorStreamInHandler::class.java)
        bind(OnActorStreamOutHandler::class.java)
        bind(OnDialogResponseHandler::class.java)
        bind(OnEnterExitModShopHandler::class.java)
        bind(OnGameModeExitHandler::class.java)
        bind(OnGameModeInitHandler::class.java)
        bind(OnIncomingConnectionHandler::class.java)
        bind(OnObjectMovedHandler::class.java)
        bind(OnPlayerClickMapHandler::class.java)
        bind(OnPlayerClickPlayerHandler::class.java)
        bind(OnPlayerClickPlayerTextDrawHandler::class.java)
        bind(OnPlayerClickTextDrawHandler::class.java)
        bind(OnPlayerCommandTextHandler::class.java)
        bind(OnPlayerConnectHandler::class.java)
        bind(OnPlayerDeathHandler::class.java)
        bind(OnPlayerDisconnectHandler::class.java)
        bind(OnPlayerEditAttachedObjectHandler::class.java)
        bind(OnPlayerEditMapObjectHandler::class.java)
        bind(OnPlayerEditPlayerMapObjectHandler::class.java)
        bind(OnPlayerEnterCheckpointHandler::class.java)
        bind(OnPlayerEnterRaceCheckpointHandler::class.java)
        bind(OnPlayerEnterVehicleHandler::class.java)
        bind(OnPlayerExitedMenuHandler::class.java)
        bind(OnPlayerExitVehicleHandler::class.java)
        bind(OnPlayerGiveDamageActorHandler::class.java)
        bind(OnPlayerGiveDamageHandler::class.java)
        bind(OnPlayerInteriorChangeHandler::class.java)
        bind(OnPlayerKeyStateChangeHandler::class.java)
        bind(OnPlayerLeaveCheckpointHandler::class.java)
        bind(OnPlayerLeaveRaceCheckpointHandler::class.java)
        bind(OnPlayerObjectMovedHandler::class.java)
        bind(OnPlayerPickUpPickupHandler::class.java)
        bind(OnPlayerRequestClassHandler::class.java)
        bind(OnPlayerRequestSpawnHandler::class.java)
        bind(OnPlayerSelectedMenuRowHandler::class.java)
        bind(OnPlayerSelectMapObjectHandler::class.java)
        bind(OnPlayerSelectPlayerMapObjectHandler::class.java)
        bind(OnPlayerSpawnHandler::class.java)
        bind(OnPlayerStateChangeHandler::class.java)
        bind(OnPlayerStreamInHandler::class.java)
        bind(OnPlayerStreamOutHandler::class.java)
        bind(OnPlayerTakeDamageHandler::class.java)
        bind(OnPlayerTextHandler::class.java)
        bind(OnPlayerUpdateHandler::class.java)
        bind(OnPlayerWeaponShotHandler::class.java)
        bind(OnProcessTickHandler::class.java)
        bind(OnRconCommandHandler::class.java)
        bind(OnRconLoginAttemptHandler::class.java)
        bind(OnTrailerUpdateHandler::class.java)
        bind(OnUnoccupiedVehicleUpdateHandler::class.java)
        bind(OnVehicleDamageStatusUpdateHandler::class.java)
        bind(OnVehicleDeathHandler::class.java)
        bind(OnVehicleModHandler::class.java)
        bind(OnVehiclePaintjobHandler::class.java)
        bind(OnVehicleResprayHandler::class.java)
        bind(OnVehicleSirenStateChangeHandler::class.java)
        bind(OnVehicleSpawnHandler::class.java)
        bind(OnVehicleStreamInHandler::class.java)
        bind(OnVehicleStreamOutHandler::class.java)
        bind(OnVehicleDestructionHandler::class.java)
        bind(OnPlayerNameChangeHandler::class.java)

        newCallbackListenerRegistrySetBinder().apply {
            addBinding().to(OnActorStreamInHandler::class.java)
            addBinding().to(OnActorStreamOutHandler::class.java)
            addBinding().to(OnDialogResponseHandler::class.java)
            addBinding().to(OnEnterExitModShopHandler::class.java)
            addBinding().to(OnGameModeExitHandler::class.java)
            addBinding().to(OnGameModeInitHandler::class.java)
            addBinding().to(OnIncomingConnectionHandler::class.java)
            addBinding().to(OnObjectMovedHandler::class.java)
            addBinding().to(OnPlayerClickMapHandler::class.java)
            addBinding().to(OnPlayerClickPlayerHandler::class.java)
            addBinding().to(OnPlayerClickPlayerTextDrawHandler::class.java)
            addBinding().to(OnPlayerClickTextDrawHandler::class.java)
            addBinding().to(OnPlayerCommandTextHandler::class.java)
            addBinding().to(OnPlayerConnectHandler::class.java)
            addBinding().to(OnPlayerDeathHandler::class.java)
            addBinding().to(OnPlayerDisconnectHandler::class.java)
            addBinding().to(OnPlayerEditAttachedObjectHandler::class.java)
            addBinding().to(OnPlayerEditMapObjectHandler::class.java)
            addBinding().to(OnPlayerEditPlayerMapObjectHandler::class.java)
            addBinding().to(OnPlayerEnterCheckpointHandler::class.java)
            addBinding().to(OnPlayerEnterRaceCheckpointHandler::class.java)
            addBinding().to(OnPlayerEnterVehicleHandler::class.java)
            addBinding().to(OnPlayerExitedMenuHandler::class.java)
            addBinding().to(OnPlayerExitVehicleHandler::class.java)
            addBinding().to(OnPlayerGiveDamageActorHandler::class.java)
            addBinding().to(OnPlayerGiveDamageHandler::class.java)
            addBinding().to(OnPlayerInteriorChangeHandler::class.java)
            addBinding().to(OnPlayerKeyStateChangeHandler::class.java)
            addBinding().to(OnPlayerLeaveCheckpointHandler::class.java)
            addBinding().to(OnPlayerLeaveRaceCheckpointHandler::class.java)
            addBinding().to(OnPlayerObjectMovedHandler::class.java)
            addBinding().to(OnPlayerPickUpPickupHandler::class.java)
            addBinding().to(OnPlayerRequestClassHandler::class.java)
            addBinding().to(OnPlayerRequestSpawnHandler::class.java)
            addBinding().to(OnPlayerSelectedMenuRowHandler::class.java)
            addBinding().to(OnPlayerSelectMapObjectHandler::class.java)
            addBinding().to(OnPlayerSelectPlayerMapObjectHandler::class.java)
            addBinding().to(OnPlayerSpawnHandler::class.java)
            addBinding().to(OnPlayerStateChangeHandler::class.java)
            addBinding().to(OnPlayerStreamInHandler::class.java)
            addBinding().to(OnPlayerStreamOutHandler::class.java)
            addBinding().to(OnPlayerTakeDamageHandler::class.java)
            addBinding().to(OnPlayerTextHandler::class.java)
            addBinding().to(OnPlayerUpdateHandler::class.java)
            addBinding().to(OnPlayerWeaponShotHandler::class.java)
            addBinding().to(OnProcessTickHandler::class.java)
            addBinding().to(OnRconCommandHandler::class.java)
            addBinding().to(OnRconLoginAttemptHandler::class.java)
            addBinding().to(OnTrailerUpdateHandler::class.java)
            addBinding().to(OnUnoccupiedVehicleUpdateHandler::class.java)
            addBinding().to(OnVehicleDamageStatusUpdateHandler::class.java)
            addBinding().to(OnVehicleDeathHandler::class.java)
            addBinding().to(OnVehicleModHandler::class.java)
            addBinding().to(OnVehiclePaintjobHandler::class.java)
            addBinding().to(OnVehicleResprayHandler::class.java)
            addBinding().to(OnVehicleSirenStateChangeHandler::class.java)
            addBinding().to(OnVehicleSpawnHandler::class.java)
            addBinding().to(OnVehicleStreamInHandler::class.java)
            addBinding().to(OnVehicleStreamOutHandler::class.java)
            addBinding().to(OnVehicleDestructionHandler::class.java)
            addBinding().to(OnPlayerNameChangeHandler::class.java)
        }
    }
}
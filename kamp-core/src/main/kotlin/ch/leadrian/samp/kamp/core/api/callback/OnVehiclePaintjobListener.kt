package ch.leadrian.samp.kamp.core.api.callback

import ch.leadrian.samp.kamp.core.api.entity.Player
import ch.leadrian.samp.kamp.core.api.entity.Vehicle

interface OnVehiclePaintjobListener {

    fun onVehiclePaintjob(player: Player, vehicle: Vehicle, paintjobId: Int): Boolean

}

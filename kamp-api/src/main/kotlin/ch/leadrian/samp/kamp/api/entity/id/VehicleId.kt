package ch.leadrian.samp.kamp.api.entity.id

import ch.leadrian.samp.kamp.api.constants.SAMPConstants

data class VehicleId internal constructor(val value: Int) {

    companion object {

        private val vehicleIds: Array<VehicleId> = (0..SAMPConstants.MAX_VEHICLES).map { VehicleId(it) }.toTypedArray()

        fun valueOf(value: Int): VehicleId =
                when {
                    0 <= value && value < vehicleIds.size -> vehicleIds[value]
                    else -> VehicleId(value)
                }
    }
}
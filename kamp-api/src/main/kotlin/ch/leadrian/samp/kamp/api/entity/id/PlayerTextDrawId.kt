package ch.leadrian.samp.kamp.api.entity.id

import ch.leadrian.samp.kamp.api.constants.SAMPConstants

data class PlayerTextDrawId internal constructor(val value: Int) {

    companion object {

        val INVALID = PlayerTextDrawId(SAMPConstants.INVALID_TEXT_DRAW)

        private val playerTextDrawIds: Array<PlayerTextDrawId> = (0..SAMPConstants.MAX_PLAYER_TEXT_DRAWS).map { PlayerTextDrawId(it) }.toTypedArray()

        fun valueOf(value: Int): PlayerTextDrawId =
                when {
                    value == SAMPConstants.INVALID_TEXT_DRAW -> INVALID
                    0 <= value && value < playerTextDrawIds.size -> playerTextDrawIds[value]
                    else -> PlayerTextDrawId(value)
                }
    }
}
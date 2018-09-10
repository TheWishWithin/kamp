package ch.leadrian.samp.kamp.core.api.callback

import ch.leadrian.samp.kamp.core.api.entity.PlayerKeys

interface OnPlayerKeyStateChangeListener {

    fun onPlayerKeyStateChange(oldKeys: PlayerKeys, newKeys: PlayerKeys)

}
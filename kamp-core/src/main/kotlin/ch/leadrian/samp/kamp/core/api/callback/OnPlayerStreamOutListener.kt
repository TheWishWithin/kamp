package ch.leadrian.samp.kamp.core.api.callback

import ch.leadrian.samp.kamp.annotations.CallbackListener
import ch.leadrian.samp.kamp.core.api.entity.Player

@CallbackListener(runtimePackageName = "ch.leadrian.samp.kamp.core.runtime.callback")
interface OnPlayerStreamOutListener {

    fun onPlayerStreamOut(player: Player, forPlayer: Player)

}

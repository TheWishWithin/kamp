package ch.leadrian.samp.kamp.core.api.command

import ch.leadrian.samp.kamp.core.api.callback.OnPlayerCommandTextListener
import ch.leadrian.samp.kamp.core.api.data.Colors
import ch.leadrian.samp.kamp.core.api.entity.Player
import ch.leadrian.samp.kamp.core.api.text.MessageSender
import ch.leadrian.samp.kamp.core.api.text.TextKey
import ch.leadrian.samp.kamp.core.api.text.TextProvider
import javax.inject.Inject

class DefaultUnknownCommandHandler
@Inject constructor(
        private val textProvider: TextProvider,
        private val messageSender: MessageSender
) : UnknownCommandHandler {

    private val unknownCommandTextKey = TextKey("unknown.command")

    override fun handle(player: Player, command: String, parameters: List<String>): OnPlayerCommandTextListener.Result {
        messageSender.sendMessageToPlayer(player, Colors.RED, unknownCommandTextKey, command, parameters.joinToString(" "))
        return OnPlayerCommandTextListener.Result.Processed
    }
}
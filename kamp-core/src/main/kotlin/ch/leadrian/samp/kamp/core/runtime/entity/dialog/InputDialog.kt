package ch.leadrian.samp.kamp.core.runtime.entity.dialog

import ch.leadrian.samp.kamp.core.api.callback.OnDialogResponseListener
import ch.leadrian.samp.kamp.core.api.constants.DialogResponse
import ch.leadrian.samp.kamp.core.api.constants.DialogStyle
import ch.leadrian.samp.kamp.core.api.entity.Player
import ch.leadrian.samp.kamp.core.api.entity.dialog.Dialog
import ch.leadrian.samp.kamp.core.api.entity.dialog.DialogInputValidator
import ch.leadrian.samp.kamp.core.api.entity.dialog.DialogTextSupplier
import ch.leadrian.samp.kamp.core.api.entity.dialog.FunctionalDialogTextSupplier
import ch.leadrian.samp.kamp.core.api.entity.dialog.InputDialogBuilder
import ch.leadrian.samp.kamp.core.api.entity.dialog.StringDialogTextSupplier
import ch.leadrian.samp.kamp.core.api.entity.dialog.TextKeyDialogTextSupplier
import ch.leadrian.samp.kamp.core.api.entity.id.DialogId
import ch.leadrian.samp.kamp.core.api.text.TextKey
import ch.leadrian.samp.kamp.core.api.text.TextProvider
import ch.leadrian.samp.kamp.core.runtime.entity.registry.DialogRegistry

internal class InputDialog(
        id: DialogId,
        private val captionTextSupplier: DialogTextSupplier,
        private val leftButtonTextSupplier: DialogTextSupplier,
        private val rightButtonTextSupplier: DialogTextSupplier,
        private val messageTextSupplier: DialogTextSupplier,
        private val isPasswordInput: Dialog.(Player) -> Boolean,
        private val validators: List<DialogInputValidator>,
        private val onSubmit: (Dialog.(Player, String) -> Unit)?,
        private val onInvalidInput: (Dialog.(Player, Any) -> Unit)?,
        private val onCancel: (Dialog.(Player) -> OnDialogResponseListener.Result)?
) : AbstractDialog(id) {

    override fun show(forPlayer: Player) {
        val style = when {
            isPasswordInput(this, forPlayer) -> DialogStyle.PASSWORD
            else -> DialogStyle.INPUT
        }
        forPlayer.showDialog(
                dialog = this,
                style = style,
                button1 = leftButtonTextSupplier.getText(forPlayer),
                button2 = rightButtonTextSupplier.getText(forPlayer),
                caption = captionTextSupplier.getText(forPlayer),
                message = messageTextSupplier.getText(forPlayer)
        )
    }

    override fun onResponse(
            player: Player,
            response: DialogResponse,
            listItem: Int,
            inputText: String
    ): OnDialogResponseListener.Result {
        return when (response) {
            DialogResponse.LEFT_BUTTON -> {
                val validationError = validators.asSequence().mapNotNull {
                    it.validate(player, inputText)
                }.firstOrNull()
                when {
                    validationError != null -> onInvalidInput?.invoke(this, player, validationError)
                    else -> onSubmit?.invoke(this, player, inputText)
                }
                OnDialogResponseListener.Result.Processed
            }
            DialogResponse.RIGHT_BUTTON -> onCancel?.invoke(this, player) ?: OnDialogResponseListener.Result.Ignored
        }
    }

    internal class Builder(
            textProvider: TextProvider,
            private val dialogRegistry: DialogRegistry
    ) : AbstractDialogBuilder<InputDialogBuilder>(textProvider), InputDialogBuilder {

        private var messageTextSupplier: DialogTextSupplier = StringDialogTextSupplier(" ")

        private var isPasswordInput: Dialog.(Player) -> Boolean = { false }

        private var onSubmit: (Dialog.(Player, String) -> Unit)? = null

        private var onInvalidInput: (Dialog.(Player, Any) -> Unit)? = null

        private var onCancel: (Dialog.(Player) -> OnDialogResponseListener.Result)? = null

        private val validators = mutableListOf<DialogInputValidator>()

        override fun message(text: String): Builder {
            messageTextSupplier = StringDialogTextSupplier(text)
            return self
        }

        override fun message(textKey: TextKey): Builder {
            messageTextSupplier = TextKeyDialogTextSupplier(textKey, textProvider)
            return self
        }

        override fun message(supplier: (Player) -> String): Builder {
            messageTextSupplier = FunctionalDialogTextSupplier(supplier)
            return self
        }

        override fun message(supplier: DialogTextSupplier): Builder {
            messageTextSupplier = supplier
            return self
        }

        override fun validator(validator: DialogInputValidator): Builder {
            validators += validator
            return self
        }

        override fun validators(vararg validator: DialogInputValidator): Builder {
            validators += validator
            return self
        }

        override fun validators(validators: Collection<DialogInputValidator>): Builder {
            this.validators.addAll(validators)
            return self
        }

        override fun isPasswordInput(isPasswordInput: Boolean): Builder {
            this.isPasswordInput = { isPasswordInput }
            return self
        }

        override fun isPasswordInput(isPasswordInput: Dialog.(Player) -> Boolean): Builder {
            this.isPasswordInput = isPasswordInput
            return self
        }

        override fun onSubmit(onSubmit: Dialog.(Player, String) -> Unit): Builder {
            this.onSubmit = onSubmit
            return self
        }

        override fun onInvalidInput(onInvalidInput: Dialog.(Player, Any) -> Unit): Builder {
            this.onInvalidInput = onInvalidInput
            return self
        }

        override fun onCancel(onCancel: Dialog.(Player) -> OnDialogResponseListener.Result): Builder {
            this.onCancel = onCancel
            return self
        }

        override fun build(): InputDialog = dialogRegistry.register { dialogId ->
            InputDialog(
                    id = dialogId,
                    captionTextSupplier = captionTextSupplier,
                    leftButtonTextSupplier = leftButtonTextSupplier,
                    rightButtonTextSupplier = rightButtonTextSupplier,
                    messageTextSupplier = messageTextSupplier,
                    isPasswordInput = isPasswordInput,
                    validators = validators,
                    onSubmit = onSubmit,
                    onInvalidInput = onInvalidInput,
                    onCancel = onCancel
            )
        }

        override val self: Builder = this

    }
}
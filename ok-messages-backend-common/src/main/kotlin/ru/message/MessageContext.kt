package ru.message

import ru.message.errors.Error
import ru.message.models.MessageModel

data class MessageContext(
        var requestMessageId: String = "",
        var requestMessage: MessageModel = MessageModel(),
        var responseMessage: MessageModel = MessageModel(),
        val errors: MutableList<Error> = mutableListOf(),
        var status: MessageContextStatus = MessageContextStatus.SUCCESS,
)
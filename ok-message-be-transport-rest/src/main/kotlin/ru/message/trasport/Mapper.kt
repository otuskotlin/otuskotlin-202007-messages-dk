package ru.message.trasport

import ru.message.MessageContext
import ru.message.models.MessageModel
import ru.message.trasport.request.MessageCreate
import ru.message.trasport.request.MessageDelete
import ru.message.trasport.request.MessageGet
import ru.message.trasport.response.MessageResponse

fun MessageContext.setQuery(create: MessageCreate) = this.apply {
    requestMessage = create.model()
}

fun MessageContext.setQuery(get: MessageGet) = this.apply {
    requestMessage.id = get.id ?: ""
}

fun MessageContext.setQuery(get: MessageDelete) = this.apply {
    requestMessage.id = get.id ?: ""
}

fun MessageContext.resultItem(): MessageResponse = MessageResponse(
        id = requestMessage.id,
        value = requestMessage.value,
        status = "success"
)

fun MessageCreate.model() = MessageModel(
        id = id.modelToString(),
        value = value.modelToString(),
        senderId = senderId.modelToString(),
        recipientsIds = recipientsIds ?: listOf()
)

private fun String?.modelToString() = this?.takeIf { it.isNotBlank() } ?: ""

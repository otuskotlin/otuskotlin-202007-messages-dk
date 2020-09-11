package ru.message.trasport

import org.slf4j.LoggerFactory
import ru.message.MessageContext
import ru.message.MessageContextStatus
import ru.message.errors.Error
import ru.message.models.MessageModel
import ru.message.models.MessageStatus
import ru.message.trasport.request.MessageCreate
import ru.message.trasport.request.MessageDelete
import ru.message.trasport.request.MessageGet
import ru.message.trasport.response.MessageResponse
import java.util.*

class MessageService {

    private val log = LoggerFactory.getLogger(this::class.java)!!

    private val defaultMessage = MessageModel(
            id = "1",
            senderId = "1",
            recipientsIds = listOf("2"),
            value = "Hello world",
            status = MessageStatus.READ
    )

    suspend fun get(query: MessageGet): MessageResponse = MessageContext().run {
        try {
            setQuery(query)
            responseMessage = defaultMessage.copy(id = query.id ?: throw RuntimeException("No messageId"))
            status = MessageContextStatus.SUCCESS
        } catch (e: Throwable) {
            log.error("Get chain error", e)
            errors += Error()
        }
        resultItem()
    }

    fun create(query: MessageCreate): MessageResponse = MessageContext().run {
        try {
            setQuery(query)
            responseMessage = defaultMessage.copy(id = UUID.randomUUID().toString())
            status = MessageContextStatus.SUCCESS
        } catch (e: Throwable) {
            log.error("Create chain error", e)
            errors += Error()
        }
        resultItem()
    }

    fun delete(query: MessageDelete): MessageResponse = MessageContext().run {
        try {
            setQuery(query)
            responseMessage = defaultMessage.copy()
            status = MessageContextStatus.SUCCESS
        } catch (e: Throwable) {
            log.error("Delete chain error", e)
            errors += Error()
        }
        resultItem()
    }

}
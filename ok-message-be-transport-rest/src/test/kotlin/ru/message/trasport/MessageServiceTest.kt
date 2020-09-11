package ru.message.trasport

import kotlinx.coroutines.runBlocking
import ru.message.MessageContext
import ru.message.models.MessageModel
import ru.message.trasport.request.MessageCreate
import ru.message.trasport.request.MessageDelete
import ru.message.trasport.request.MessageGet
import kotlin.test.Test
import kotlin.test.assertEquals

internal class MessageServiceTest {

    val processor = Processor()

    class Processor() {
        suspend fun get(context: MessageContext): MessageContext = context.apply { responseMessage = MessageModel(id = "1", senderId = "2", value = "Message") }
        suspend fun create(context: MessageContext): MessageContext = context.apply { responseMessage = requestMessage.copy(id = "2") }
        suspend fun delete(context: MessageContext): MessageContext = context.apply { responseMessage = requestMessage.copy() }
    }

    @Test
    fun create() {
        val context = MessageContext()
        val result = runBlocking {
            processor.create(context.setQuery(MessageCreate(id = "1", value = "Message", senderId = "2", listOf()))).resultItem()
        }
        assertEquals("1", result.id)
        assertEquals("Message", result.value)
    }

    @Test
    fun get() {
        val context = MessageContext()
        val result = runBlocking {
            processor.get(context.setQuery(MessageGet(id = "1"))).resultItem()
        }
        assertEquals("1", result.id)
    }

    @Test
    fun delete() {
        val context = MessageContext()
        val result = runBlocking {
            processor.delete(context.setQuery(MessageDelete(id = "1"))).resultItem()
        }
        assertEquals("1", result.id)
    }
}
package ru.message.trasport.response

import org.junit.Test
import kotlin.test.assertEquals


internal class MessageResponseTest {

    @Test
    fun createEmptyMessageResponse() {
        val message = MessageResponse()
        assertEquals(null, message.id)
        assertEquals(null, message.value)
        assertEquals(null, message.status)
    }

    @Test
    fun createMessageResponse() {
        val message = MessageResponse(id = "1", value = "Message", status = "unknown")
        assertEquals("1", message.id)
        assertEquals("Message", message.value)
        assertEquals("unknown", message.status)
    }
}
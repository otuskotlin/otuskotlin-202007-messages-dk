package ru.message.models

import java.time.LocalTime
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import kotlin.test.assertTrue

internal class MessageModelTest {

    @Test
    fun createEmptyMessage() {
        val message = MessageModel()
        assertTrue(message.recipientsIds.isEmpty())
        assertEquals("", message.id)
        assertEquals("", message.senderId)
        assertEquals("", message.value)
        assertNotNull(message.createTime)
    }

    @Test
    fun createActualMessage() {
        val message = MessageModel(
                id = "1",
                senderId = "2",
                value = "Simple message",
                recipientsIds = listOf("3", "4", "5"),
                createTime = LocalTime.MIN
        )
        assertTrue(message.recipientsIds.size == 3)
        assertEquals(listOf("3", "4", "5"), message.recipientsIds)
        assertEquals("1", message.id)
        assertEquals("2", message.senderId)
        assertEquals("Simple message", message.value)
        assertEquals(LocalTime.MIN, message.createTime)
    }
}
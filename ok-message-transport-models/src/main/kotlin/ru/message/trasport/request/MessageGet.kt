package ru.message.trasport.request

import kotlinx.serialization.Serializable

@Serializable
data class MessageGet(
        val id: String? = null
)
package ru.message.trasport.request

import kotlinx.serialization.Serializable

@Serializable
data class MessageDelete(
        @Transient var id: String? = null
)
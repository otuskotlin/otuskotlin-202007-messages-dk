package ru.message.trasport.request

import kotlinx.serialization.Serializable

@Serializable
data class MessageCreate(
        @Transient var id: String? = null,
        @Transient var value: String? = null,
        @Transient var senderId: String? = null,
        @Transient var recipientsIds: List<String>? = null,
)
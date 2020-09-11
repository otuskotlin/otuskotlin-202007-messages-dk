package ru.message.trasport.response

import kotlinx.serialization.Serializable

@Serializable
data class MessageResponse(
        var id: String? = null,
        var value: String? = null,
        var status: String? = null
)
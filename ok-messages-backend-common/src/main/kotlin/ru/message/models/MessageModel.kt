package ru.message.models

import java.time.LocalTime

data class MessageModel(
        var id: String = "",
        var senderId: String = "",
        var recipientsIds: List<String> = mutableListOf(),
        var value: String = "",
        var createTime: LocalTime = LocalTime.now(),
        var status: MessageStatus = MessageStatus.EMPTY
)

data class DialogModel(
        val id: String = "",
        val messages: MutableList<MessageModel> = mutableListOf()
)

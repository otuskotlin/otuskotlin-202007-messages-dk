package ru.message.errors

data class Error(
        var message: String = "",
        var code: Int = 0,
        var status: ErrorStatuses = ErrorStatuses.EMPTY
)
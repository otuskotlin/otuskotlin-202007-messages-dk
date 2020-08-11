package ru.otuskotlin.users.backend

import java.time.LocalDate

data class UserModel (val id: String = "",
                      var firstName: String = "",
                      var secondName: String = "",
                      var lastName: String = "",
                      var birthDate: LocalDate = LocalDate.MIN
)

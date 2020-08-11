package ru.otuskotlin.users.backend

import kotlin.test.Test
import kotlin.test.assertEquals


class UserModelTest {

    @Test
    fun createSimpleUserModel() {
        val user = UserModel(
                firstName = "Danila",
                secondName = "Kozlov"
        )
        assertEquals(user.firstName, "Danila")
        assertEquals(user.secondName, "Kozlov")
        assertEquals(user.lastName, "")
    }
}
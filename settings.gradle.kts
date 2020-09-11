rootProject.name = "messages"

include(":ok-messages-backend-common")
include("ok-message-transport-models")
include("ok-message-be-transport-rest")

pluginManagement {
    plugins {
        val kotlinVersion: String by settings

        kotlin("jvm") version kotlinVersion apply false
        kotlin("multiplatform") version kotlinVersion apply false
        kotlin("plugin.serialization") version kotlinVersion apply false
    }
}

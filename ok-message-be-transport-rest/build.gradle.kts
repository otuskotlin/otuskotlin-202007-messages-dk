plugins {
    kotlin("jvm")
}

group = rootProject.group
version = rootProject.version

repositories {
    mavenCentral()
}

dependencies {
    val slf4jVersion: String by project
    val coroutinesVersion: String by project

    api(project(":ok-messages-backend-common"))
    api(project(":ok-message-transport-models"))

    implementation(kotlin("stdlib"))
    implementation("org.slf4j:slf4j-api:$slf4jVersion")

    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutinesVersion")
    testImplementation(kotlin("test"))
    testImplementation(kotlin("test-junit"))
}
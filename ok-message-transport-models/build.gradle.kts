plugins {
    kotlin("jvm")
    kotlin("plugin.serialization")
}

group = rootProject.group
version = rootProject.version

repositories {
    mavenCentral()
    jcenter()
}

dependencies {
    val slf4jVersion: String by project
    val serializationVersion: String by project

    api(project(":ok-messages-backend-common"))

    implementation("org.jetbrains.kotlinx:kotlinx-serialization-core:$serializationVersion")
    implementation(kotlin("stdlib"))
    implementation("org.slf4j:slf4j-api:$slf4jVersion")
    testImplementation(kotlin("test"))
    testImplementation(kotlin("test-junit"))
}
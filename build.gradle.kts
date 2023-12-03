plugins {
    kotlin("jvm") version "1.9.21"
    application
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
//retrofit
    testImplementation ("com.squareup.retrofit2:retrofit:2.9.0" )
    testImplementation ("com.squareup.retrofit2:converter-gson:2.9.0" )
    testImplementation ("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.3.5")
    testImplementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.3.5")
    testImplementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.3.1")
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(8)
}

application {
    mainClass.set("MainKt")
}

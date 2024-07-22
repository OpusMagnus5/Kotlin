plugins {
    kotlin("jvm") version "1.9.22"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.jetbrains.kotlin:kotlin-test")
    testImplementation("org.junit.jupiter:junit-jupiter:5.10.3")
    testImplementation("io.mockk:mockk:1.13.12")
}

tasks.test {//dokładamy uruchomienie testó
    useJUnitPlatform()

    testLogging {
        events("passed", "skipped", "failed")
    }
}
kotlin {
    jvmToolchain(21)
}
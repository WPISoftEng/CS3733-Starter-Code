import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    application
    java
    id("com.diffplug.spotless") version "6.16.0"
    id("org.openjfx.javafxplugin") version "0.0.13"
    kotlin("jvm") version "1.8.10"
}

application {
    mainClass.set("edu.wpi.teamname.MainKt")
}

repositories {
    mavenCentral()
}

javafx {
    version = "19"
    modules("javafx.controls", "javafx.fxml", "javafx.graphics", "javafx.media", "javafx.swing")
}

dependencies {
    //MaterialFX UI Framework
    implementation("io.github.palexdev:materialfx:11.13.9")

    // You may comment out the database dependency you do not use
    implementation("org.xerial:sqlite-jdbc:3.36.0.3")
    implementation("org.apache.derby:derby:10.15.2.0")
    implementation("io.insert-koin:koin-core:3.3.3")

    testImplementation("org.mockito.kotlin:mockito-kotlin:4.1.0")
    testImplementation("org.testfx:testfx-core:4.0.16-alpha")
    testImplementation("org.junit.jupiter:junit-jupiter:5.8.2")
    testImplementation("org.testfx:testfx-junit5:4.0.16-alpha")
    testImplementation("com.nhaarman.mockitokotlin2:mockito-kotlin:2.2.0")
    implementation(kotlin("stdlib-jdk8"))
    implementation(kotlin("reflect"))

}

tasks.test {
    useJUnitPlatform()
}

spotless {
    kotlin {
        ktfmt().kotlinlangStyle()
    }
    java {
        googleJavaFormat()
    }
}

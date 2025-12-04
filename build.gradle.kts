//val agpVersion: String by extra("9.2.1") // Define AGP version
val agpVersion: String by extra("8.13.2") // Use a stable AGP version like 8.3.2 or 8.4.0
val kotlinJvmTarget: JavaVersion by extra(JavaVersion.VERSION_17) // Define Kotlin JVM target

// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    val agp_version by extra("8.13.2")
    val agp_version1 by extra("8.13.2")
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal() // Optional, but recommended for other plugins
    }

    // The ext.kotlin_version line has been removed from here.
    // If you need to use kotlin_version for a buildscript dependency (e.g., kotlin-gradle-plugin),
    // you would do it like this:
    // dependencies {
    //    classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${kotlin_version}")
    // }
    // However, for modern Android projects, the Kotlin plugin is often applied via the plugins block
    // in the app module's build.gradle.kts, making a classpath dependency here unnecessary.
}
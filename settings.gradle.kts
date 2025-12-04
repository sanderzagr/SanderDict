include (":app")
pluginManagement {
    repositories {
        google() // Required for Android Gradle Plugin (AGP)
        mavenCentral()
        gradlePluginPortal() // Default source for most other plugins
        // Add JitPack here (optional for plugins, but harmless)
        maven("https://jitpack.io")
    }
}
dependencyResolutionManagement { // <-- ADD THIS BLOCK HERE
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        // *** CRUCIAL FIX: Add JitPack repository here ***
        maven("https://jitpack.io")
    }
}
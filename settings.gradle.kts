include (":app")
pluginManagement {
    repositories {
        google() // Required for Android Gradle Plugin (AGP)
        mavenCentral()
        gradlePluginPortal() // Default source for most other plugins
    }
}
dependencyResolutionManagement { // <-- ADD THIS BLOCK HERE
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}
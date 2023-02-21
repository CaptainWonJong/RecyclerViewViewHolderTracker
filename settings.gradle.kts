pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "EventDispatcher"
include(":app")
include(
    ":data:model",
    ":data:remote",
    ":data:repositoryImpl",
)
include(
    ":domain:repository",
    ":domain:entity",
    ":domain:usecase",
)

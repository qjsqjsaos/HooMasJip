pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}
rootProject.name = "후맛집_후기로 찾는 맛집탐방"
include(
        ":app",
        ":domain",
        ":data",
        ":shared"
)
include(":paging3sample")
include(":apisample")

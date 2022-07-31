import kr.loner.buildsrc.Kotlin
import kr.loner.buildsrc.AppVersions
plugins {
    id("com.android.library")
    kotlin("android")
}

android{
    compileSdk = AppVersions.compileSdk
}

dependencies {
    implementation(project(":domain"))
    implementation(project(":shared"))

    testImplementation(Kotlin.junit)
}
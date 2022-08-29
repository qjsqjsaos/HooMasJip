import kr.loner.buildsrc.Kotlin
import kr.loner.buildsrc.AppVersions
import kr.loner.buildsrc.Network

plugins {
    id("com.android.library")
    kotlin("android")
    id("org.jetbrains.kotlin.plugin.serialization")
}

android{
    compileSdk = AppVersions.compileSdk
}

dependencies {
    implementation(project(":domain"))
    implementation(project(":shared"))

    testImplementation(Kotlin.junit)
    implementation(Kotlin.coroutine)

    implementation(Network.retrofit)
    implementation(Network.okInterceptor)
    implementation(Network.okhttp)
    implementation(Network.kSerializaion)
    implementation(Network.serialConverter)
    implementation(Network.dateTime)
}
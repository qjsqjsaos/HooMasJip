import kr.loner.buildsrc.Kotlin

plugins {
    id("java-library")
    kotlin("jvm")
    kotlin("kapt")
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

dependencies{
    implementation(Kotlin.coroutine)
}
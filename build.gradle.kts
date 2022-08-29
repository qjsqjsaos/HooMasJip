
plugins {
    id("com.android.application") version "7.2.0" apply false
    id("com.android.library") version kr.loner.buildsrc.Android.androidGradleVersion apply false
    id("com.google.dagger.hilt.android") version kr.loner.buildsrc.Android.hiltGradleVersion apply false
    kotlin("android") version kr.loner.buildsrc.Kotlin.kotlinVersion apply false
    kotlin("jvm") version kr.loner.buildsrc.Kotlin.kotlinVersion
    kotlin("plugin.serialization") version kr.loner.buildsrc.Network.kSerializationGradle
}

buildscript {
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${kr.loner.buildsrc.Kotlin.kotlinVersion}")
        classpath("com.google.dagger:hilt-android-gradle-plugin:${kr.loner.buildsrc.Android.hiltGradleVersion}")
    }
}
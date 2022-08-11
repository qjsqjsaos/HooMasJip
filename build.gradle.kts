
plugins {
    id("com.android.application") version "7.1.2" apply false
    id("com.android.library") version kr.loner.buildsrc.Android.androidGradleVersion apply false
    id("com.google.dagger.hilt.android") version kr.loner.buildsrc.Android.hiltGradleVersion apply false
    kotlin("android") version kr.loner.buildsrc.Kotlin.kotlinVersion apply false
    kotlin("plugin.serialization") version "1.6.21"
    kotlin("jvm") version kr.loner.buildsrc.Kotlin.kotlinVersion apply false
}

buildscript {
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${kr.loner.buildsrc.Kotlin.kotlinVersion}")
        classpath("com.google.dagger:hilt-android-gradle-plugin:${kr.loner.buildsrc.Android.hiltGradleVersion}")
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
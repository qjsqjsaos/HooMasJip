
plugins {
    id("com.android.application") version kr.loner.buildsrc.Android.androidGradleVersion apply false
    id("com.android.library") version kr.loner.buildsrc.Android.androidGradleVersion apply false
    kotlin("android") version kr.loner.buildsrc.Kotlin.kotlinVersion apply false
    kotlin("jvm") version kr.loner.buildsrc.Kotlin.kotlinVersion apply false
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}

plugins {
    id("com.android.application") version "7.1.2" apply false
    id("com.android.library") version kr.loner.buildsrc.Android.androidGradleVersion apply false
    kotlin("android") version "1.6.21" apply false
    kotlin("jvm") version kr.loner.buildsrc.Kotlin.kotlinVersion apply false
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
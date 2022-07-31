import kr.loner.buildsrc.AppVersions
import kr.loner.buildsrc.Android
import kr.loner.buildsrc.Kotlin
plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    compileSdk = AppVersions.compileSdk

    defaultConfig {
        applicationId = AppVersions.applicationId
        minSdk = AppVersions.minSdk
        targetSdk = AppVersions.targetSdk
        versionCode = AppVersions.versionCode
        versionName = AppVersions.versionName
        testInstrumentationRunner = Android.AndroidX.Test.androidXJunitRunner
    }

    buildTypes {
        getByName("release"){
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(project(":domain"))
    implementation(project(":shared"))
    implementation(Android.AndroidX.core)
    implementation(Android.AndroidX.appCompat)
    implementation(Android.material)
    implementation(Android.AndroidX.constraintLayout)
    testImplementation(Kotlin.junit)
    androidTestImplementation(Android.AndroidX.Test.androidXJunit)

}
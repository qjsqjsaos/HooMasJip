plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
    id("org.jetbrains.kotlin.plugin.serialization")
}

android {
    compileSdk = kr.loner.buildsrc.AppVersions.compileSdk

    defaultConfig {
        applicationId = kr.loner.buildsrc.AppVersions.applicationId
        minSdk = kr.loner.buildsrc.AppVersions.minSdk
        targetSdk = kr.loner.buildsrc.AppVersions.targetSdk
        versionCode = kr.loner.buildsrc.AppVersions.versionCode
        versionName = kr.loner.buildsrc.AppVersions.versionName
        testInstrumentationRunner = kr.loner.buildsrc.Android.AndroidX.Test.androidXJunitRunner
    }

    buildTypes {
        getByName("debug") {
            extra["enableCrashlytics"] = false
        }
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
    buildFeatures {
        dataBinding = true
    }
}

dependencies {
    testImplementation(kr.loner.buildsrc.Kotlin.junit)
    implementation(kr.loner.buildsrc.Kotlin.coroutine)

    implementation(kr.loner.buildsrc.Network.retrofit)
    implementation(kr.loner.buildsrc.Network.okInterceptor)
    implementation(kr.loner.buildsrc.Network.okhttp)
    implementation(kr.loner.buildsrc.Network.kSerializaion)
    implementation(kr.loner.buildsrc.Network.serialConverter)
    implementation(kr.loner.buildsrc.Network.dateTime)

    implementation(kr.loner.buildsrc.Android.AndroidX.core)
    implementation(kr.loner.buildsrc.Android.AndroidX.appCompat)
    implementation(kr.loner.buildsrc.Android.AndroidX.activity)
    implementation(kr.loner.buildsrc.Android.AndroidX.fragment)
    implementation(kr.loner.buildsrc.Android.AndroidX.constraintLayout)
    implementation(kr.loner.buildsrc.Android.AndroidX.LifeCycle.liveData)
    implementation(kr.loner.buildsrc.Android.AndroidX.LifeCycle.viewModel)
    implementation(kr.loner.buildsrc.Android.Hilt.hilt)
    implementation("androidx.appcompat:appcompat:1.4.2")
    implementation("com.google.android.material:material:1.4.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    kapt(kr.loner.buildsrc.Android.Hilt.hiltCompiler)
    kapt(kr.loner.buildsrc.Android.metadata)
    implementation(kr.loner.buildsrc.Android.material)
    androidTestImplementation(kr.loner.buildsrc.Android.AndroidX.Test.androidXJunit)

    //glide
    implementation("com.github.bumptech.glide:glide:4.12.0")
    kapt("com.github.bumptech.glide:compiler:4.12.0")
}
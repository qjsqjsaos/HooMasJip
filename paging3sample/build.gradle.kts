import kr.loner.buildsrc.*

plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    compileSdk = 31
    defaultConfig {
        applicationId = "kr.loner.paging3sample"
        minSdk = AppVersions.minSdk
        targetSdk = AppVersions.targetSdk
        versionCode = AppVersions.versionCode
        versionName = AppVersions.versionName

        testInstrumentationRunner = Android.AndroidX.Test.androidXJunitRunner
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
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
    implementation(Android.AndroidX.LifeCycle.viewModel)
    implementation(Android.AndroidX.core)
    implementation(Android.AndroidX.appCompat)
    implementation(Android.material)
    implementation(Android.AndroidX.constraintLayout)
    implementation(Android.AndroidX.LifeCycle.liveData)
    implementation(Android.AndroidX.paging3)
    implementation(Android.AndroidX.activity)
    implementation(Android.AndroidX.LifeCycle.lifeCycleRuntime)

    implementation(Kotlin.coroutine)
    testImplementation(Kotlin.junit)
    androidTestImplementation(Android.AndroidX.Test.androidXJunit)
    androidTestImplementation(Android.AndroidX.Test.espresso)
}
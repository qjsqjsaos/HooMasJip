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
    /**TODO: 데이터 모듈은 없어야함, 샘플 코드 작성을 위해서 임시로 설정*/
    implementation(project(":data"))

    implementation(project(":domain"))
    implementation(project(":shared"))
    implementation(Android.AndroidX.core)
    implementation(Android.AndroidX.appCompat)
    implementation(Android.AndroidX.activity)
    implementation(Android.AndroidX.constraintLayout)
    implementation(Android.AndroidX.LifeCycle.liveData)
    implementation(Android.material)
    testImplementation(Kotlin.junit)
    androidTestImplementation(Android.AndroidX.Test.androidXJunit)


}
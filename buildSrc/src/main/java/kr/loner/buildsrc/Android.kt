package kr.loner.buildsrc

object Android {
    const val androidGradleVersion = "7.1.2"
    const val hiltGradleVersion = "2.42"
    const val material = "com.google.android.material:material:1.6.1"
    const val metadata = "org.jetbrains.kotlinx:kotlinx-metadata-jvm:0.4.2"

    object AndroidX {
        const val core = "androidx.core:core-ktx:1.8.0"
        const val appCompat = "androidx.appcompat:appcompat:1.4.2"
        const val constraintLayout = "androidx.constraintlayout:constraintlayout:2.1.4"

        const val activity = "androidx.activity:activity-ktx:1.4.0"
        const val fragment = "androidx.fragment:fragment-ktx:1.4.1"

        const val paging3 = "androidx.paging:paging-runtime:3.1.1"


        object Test {
            const val androidXJunit = "androidx.test.ext:junit:1.1.3"
            const val androidXJunitRunner = "androidx.test.runner.AndroidJUnitRunner"
            const val espresso = "androidx.test.espresso:espresso-core:3.4.0"
        }

        object LifeCycle {
            private val lifecycle_version = "2.5.1"
            private val arch_version = "2.1.0"
            val liveData = "androidx.lifecycle:lifecycle-livedata-ktx:$lifecycle_version"
             val viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycle_version"
            val lifeCycleRuntime = "androidx.lifecycle:lifecycle-runtime-ktx:$lifecycle_version"
        }
    }

    object Hilt {
        const val hilt = "com.google.dagger:hilt-android:2.38.1"
        const val hiltCompiler = "com.google.dagger:hilt-android-compiler:2.38.1"
        }
    }
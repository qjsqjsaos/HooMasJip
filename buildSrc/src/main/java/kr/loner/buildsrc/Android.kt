package kr.loner.buildsrc

object Android {
    const val androidGradleVersion = "7.1.2"
    const val material = "com.google.android.material:material:1.6.1"

    object AndroidX{
        const val core = "androidx.core:core-ktx:1.8.0"
        const val appCompat = "androidx.appcompat:appcompat:1.4.2"
        const val constraintLayout = "androidx.constraintlayout:constraintlayout:2.1.4"

        object Test{
            const val androidXJunit = "androidx.test.ext:junit:1.1.3"
            const val androidXJunitRunner = "androidx.test.runner.AndroidJUnitRunner"
            const val espresso = "androidx.test.espresso:espresso-core:3.4.0"
        }

    }
}
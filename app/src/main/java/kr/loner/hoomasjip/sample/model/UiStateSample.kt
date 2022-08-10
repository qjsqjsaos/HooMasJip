package kr.loner.hoomasjip.sample.model

sealed class UiStateSample{
    object Loading : UiStateSample()
    data class Failure( val exception: Throwable?) : UiStateSample()
    data class Success<T>(val data : T) : UiStateSample()
}


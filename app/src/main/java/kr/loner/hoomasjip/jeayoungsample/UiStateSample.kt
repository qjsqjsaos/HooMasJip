package kr.loner.hoomasjip.jeayoungsample

sealed class UiStateSample{
    object Loading : UiStateSample()
    data class Failure( val exception: Throwable?) : UiStateSample()
    data class Success<T>(val data : T) : UiStateSample()
}

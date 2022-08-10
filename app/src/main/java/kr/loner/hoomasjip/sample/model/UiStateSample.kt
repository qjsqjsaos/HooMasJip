package kr.loner.hoomasjip.sample.model

data class UiStateSample<T>(
    val data: T? = null,
    val loading: Boolean = false,
    val exception: Throwable? = null
) {
    companion object {
        fun <T> loading(): UiStateSample<T> = UiStateSample(loading = true)

        fun <T> success(value: T): UiStateSample<T> = UiStateSample(data = value)

        fun <T> failure(exception: Throwable): UiStateSample<T> = UiStateSample(exception = exception)
    }
}
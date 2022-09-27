package com.example.kmmtest.util

sealed class DataState<out T> {
    class Empty<T> : DataState<T>()

    data class Success<T>(
        /** The value of the loaded resource. */
        val value: T,
    ) : DataState<T>()

    data class Loading<T>(
        /** The previous exception of the resource before loading started. */
        val previousException: Exception? = null,
        val staleData: T? = null,
        val creationTimeStaleData: Long? = null,
    ) : DataState<T>()

    data class Error(
        /** The exception that occurred while loading the resource. */
        val exception: Throwable,
        val message: String,
    ) : DataState<Nothing>()

    val currentValue: T?
        get() = when (this) {
            is Success -> value
            is Loading -> staleData
            is Error -> null
            is Empty -> null
        }

    val currentException: Throwable?
        get() = when (this) {
            is Success -> null
            is Loading -> previousException
            is Error -> exception
            is Empty -> null
        }

    fun <R> map(transform: (T) -> R): DataState<R> = when (this) {
        is Success -> Success(transform(value))
        is Empty -> Empty()
        is Error -> Error(exception, message)
        is Loading -> Loading(previousException, null, null)
    }
}

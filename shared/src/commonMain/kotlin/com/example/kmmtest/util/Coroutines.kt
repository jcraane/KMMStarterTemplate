package com.example.kmmtest.util

import kotlinx.coroutines.CancellationException

/**
 * Executes the block within try-catch but rethrows CancellationException. If a CancellationException is not rethrown the parent
 * coroutine is not cancelled. See https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.coroutines.cancellation/-cancellation-exception/
 *
 * @param block The block to execute within try-catch.
 */
inline fun <R> runSuspendCatching(block: () -> R): Result<R> {
    return try {
        Result.success(block())
    } catch (c: CancellationException) {
        throw c
    } catch (e: Exception) {
        Result.failure(e)
    }
}
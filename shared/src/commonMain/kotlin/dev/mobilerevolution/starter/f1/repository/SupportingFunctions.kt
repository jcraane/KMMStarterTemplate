package dev.mobilerevolution.starter.f1.repository

import dev.mobilerevolution.starter.common.util.DataState
import dev.mobilerevolution.starter.common.util.runSuspendCatching
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

suspend fun <T> execute(operation: suspend () -> T): Flow<DataState<T>> = flow {
    emit(DataState.Loading())
    runSuspendCatching {
        emit(DataState.Success(operation()))
    }.onFailure {
        emit(DataState.Error(it, "Error retrieving data"))
    }
}

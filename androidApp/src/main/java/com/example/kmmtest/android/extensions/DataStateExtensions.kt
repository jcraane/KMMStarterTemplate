package com.example.kmmtest.android.extensions

import androidx.compose.runtime.Composable
import com.example.kmmtest.util.DataState

@Composable
fun <T> DataState<T>.ToComposable(
    onEmpty: @Composable () -> Unit = {},
    onError: @Composable () -> Unit = {},
    onLoading: @Composable (data: T?) -> Unit = {},
    onSuccess: @Composable (data: T) -> Unit = {},
) {
    when (this) {
        is DataState.Empty -> onEmpty()
        is DataState.Error -> onError()
        is DataState.Loading -> onLoading(currentValue)
        is DataState.Success -> onSuccess(value)
    }
}
package dev.mobilerevolution.starter.android.extensions

import androidx.compose.runtime.Composable
import dev.mobilerevolution.starter.common.util.DataState

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

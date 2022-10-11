package dev.mobilerevolution.starter.platform

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope

actual typealias SharedViewModel = androidx.lifecycle.ViewModel

actual val SharedViewModel.scope: CoroutineScope
    get() = this.viewModelScope

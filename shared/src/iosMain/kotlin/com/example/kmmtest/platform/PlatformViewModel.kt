package com.example.kmmtest.platform

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

actual abstract class SharedViewModel

actual val SharedViewModel.scope: CoroutineScope
    get() = MainScope(Dispatchers.Main)
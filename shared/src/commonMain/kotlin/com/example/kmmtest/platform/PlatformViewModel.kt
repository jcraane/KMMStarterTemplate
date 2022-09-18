package com.example.kmmtest.platform

import kotlinx.coroutines.CoroutineScope

expect abstract class SharedViewModel()
expect val SharedViewModel.scope: CoroutineScope
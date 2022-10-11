package dev.mobilerevolution.starter.platform

import kotlinx.coroutines.CoroutineScope

expect abstract class SharedViewModel()
expect val SharedViewModel.scope: CoroutineScope

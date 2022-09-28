package com.example.helloworldkmp

import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.context.startKoin

class GreetingHelper : KoinComponent {
    fun greet() : String = "Hello"
}

fun initKoin(){
    startKoin {
    }
}

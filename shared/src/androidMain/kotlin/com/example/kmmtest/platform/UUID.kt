package com.example.kmmtest.platform

import java.util.UUID

actual fun randomUUID() = UUID.randomUUID().toString()

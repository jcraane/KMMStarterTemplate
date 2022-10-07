package com.example.kmmtest.platform

import platform.Foundation.NSUUID

actual fun randomUUID() = NSUUID.UUID().UUIDString()

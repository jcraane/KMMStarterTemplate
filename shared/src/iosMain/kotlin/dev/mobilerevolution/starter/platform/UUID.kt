package dev.mobilerevolution.starter.platform

import platform.Foundation.NSUUID

actual fun randomUUID() = NSUUID.UUID().UUIDString()

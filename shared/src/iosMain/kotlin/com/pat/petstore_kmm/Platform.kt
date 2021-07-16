package com.pat.petstore_kmm

import io.ktor.client.engine.*
import io.ktor.client.engine.ios.*
import platform.UIKit.UIDevice

actual class Platform actual constructor() {
    actual val platform: String = UIDevice.currentDevice.systemName() + " " + UIDevice.currentDevice.systemVersion
}

actual class Injections{
    actual val engine: HttpClientEngine = Ios.create()
}
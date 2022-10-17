package dev.mobilerevolution.starter.di

import dev.mobilerevolution.starter.common.di.HttpLoggingSpec
import dev.mobilerevolution.starter.common.di.initKoin
import kotlinx.cinterop.ObjCClass
import kotlinx.cinterop.getOriginalKotlinClass
import org.koin.core.Koin
import org.koin.core.parameter.parametersOf
import org.koin.core.qualifier.Qualifier

/**
 * Convenience function to initialize Koin from iOS without having to pass in all (default) the module definitions.
 */
object KoinIOS {
    fun initKoinIos(httpLoggingSpec: HttpLoggingSpec) = initKoin(httpLoggingSpec)
}

fun Koin.get(objCClass: ObjCClass): Any {
    val kClazz = getOriginalKotlinClass(objCClass)!!
    return get(kClazz, null, null)
}

fun Koin.get(objCClass: ObjCClass, qualifier: Qualifier?, parameter: Any): Any {
    val kClazz = getOriginalKotlinClass(objCClass)!!
    return get(kClazz, qualifier) {
        parametersOf(parameter)
    }
}

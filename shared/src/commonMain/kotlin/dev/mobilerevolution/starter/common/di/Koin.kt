package dev.mobilerevolution.starter.common.di

import org.koin.core.KoinApplication
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.module

/**
 * Initializes the common Koin module.
 *
 * @param httpLoggingSpec Defines how to log http requests.
 * @param appModule Dependencies provided by the calling app. ViewModels in Android for example.
 * @param appDeclaration Can be used to configure Koin by the calling app.
 */
fun initKoin(
    httpLoggingSpec: HttpLoggingSpec,
    appModule: Module = module {},
    viewModelsModule: Module = viewModelModule(),
    appDeclaration: KoinAppDeclaration = {},
): KoinApplication {
    return startKoin {
        appDeclaration()
        modules(
            commonModule(httpLoggingSpec),
            appModule,
            viewModelsModule,
        )
    }
}

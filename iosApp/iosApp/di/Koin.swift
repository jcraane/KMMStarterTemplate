//
// Created by Jamie Craane on 28/09/2022.
// Copyright (c) 2022 orgName. All rights reserved.
//

import shared

final class Koin {
    private var core: Koin_coreKoin?

    static let instance = Koin()

    private init() {}

    static func startKoin() {
        if (instance.core == nil) {
            let loggingSpec = HttpLoggingSpec.init(enabled: true, level: Ktor_client_loggingLogLevel.all)
            let app = KoinIOS.shared.doInitKoinIos(httpLoggingSpec: loggingSpec)
            instance.core = app.koin
        }

        if (instance.core == nil) {
            fatalError("Error initializing Koin")
        }
    }

    func get<T: AnyObject>() -> T {
        guard let core = core else {
            fatalError("Call startKoin before calling \(#function)")
        }

        guard let object = core.get(objCClass: T.self) as? T else {
            fatalError("Error providing instance of: \(T.self)")
        }

        return object
    }
}

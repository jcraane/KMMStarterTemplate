import SwiftUI
import shared

@main
struct iOSApp: App {
	init() {
		let loggingSpec = HttpLoggingSpec.init(enabled: true, level: Ktor_client_loggingLogLevel.all)
		KoinKt.doInitKoinIos(httpLoggingSpec: loggingSpec)
	}

	var body: some Scene {
		WindowGroup {
			ContentView()
		}
	}
}
import SwiftUI
import shared

@main
struct iOSApp: App {
	init() {
		Koin.startKoin()
	}

	var body: some Scene {
		WindowGroup {
			ContentView()
		}
	}
}
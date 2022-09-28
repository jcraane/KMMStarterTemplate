//
//  UsersScreen.swift
//  iosApp
//
//  Created by Jamie Craane on 28/09/2022.
//  Copyright © 2022 orgName. All rights reserved.
//

import SwiftUI
import shared
import Combine
import KMPNativeCoroutinesCombine

struct UsersScreen: View {
    let usersViewModel: UsersViewModel = Koin.instance.get()
    var cancellable: AnyCancellable?

    init() {
        cancellable = createPublisher(for: usersViewModel.usersNative)
                .receive(on: DispatchQueue.main)
                .sink { completion in
                    print("Received completion: \(completion)")
                } receiveValue: { value in
                    print("Received value: \(value)")
                }
    }

    var body: some View {
        Text(usersViewModel.greet())


        Text("Hello")
        /*ObservingView(statePublisher: createPublisher(for: publisher),
                content: { state in

                    // your view here
                })*/
    }
}

struct UsersScreenContent: View {
    var body: some View {
        Text("jds")
    }
}

struct UsersScreen_Previews: PreviewProvider {
    static var previews: some View {
        UsersScreen()
    }
}

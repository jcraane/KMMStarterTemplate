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

    var body: some View {
        ObservingView(statePublisher: createPublisher(for: usersViewModel.usersNative).assertNoFailure().eraseToAnyPublisher(),
                content: { state in
                    if (state is DataStateSuccess) {
                        let users = (state as? DataStateSuccess)?.value as? [User]

                        ForEach(users!, id: \.id) { user in
                            HStack {
                                Text(user.id)
                                Text(user.name)
                            }
                        }
                    }
                })
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

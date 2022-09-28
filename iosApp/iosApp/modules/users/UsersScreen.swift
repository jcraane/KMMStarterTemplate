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
                        Text("Success")
//                        let cast = (state as? DataStateSuccess)
                        Text("\(state)")

//                        cast?.value.forEach { int8 in

//                            Text(int8)
//                        }
                        /*ForEach(cast.value) { user in
                            Text("User")
                        }*/
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

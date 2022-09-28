//
//  UsersScreen.swift
//  iosApp
//
//  Created by Jamie Craane on 28/09/2022.
//  Copyright © 2022 orgName. All rights reserved.
//

import SwiftUI
import shared

struct UsersScreen: View {
    let usersViewModel: UsersViewModel = Koin.instance.get()

    var body: some View {
        Text(usersViewModel.greet())
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

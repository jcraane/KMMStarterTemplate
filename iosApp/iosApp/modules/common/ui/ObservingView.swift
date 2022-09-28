//
// Created by Jamie Craane on 28/09/2022.
// Copyright (c) 2022 orgName. All rights reserved.
//

import SwiftUI
import Combine

/*
private class ObservableModel<State, Action>: ObservableObject {
    @Published var state: State?
    @Published var action: Action?

    init(statePublisher: AnyPublisher<State, Never>,
         actionPublisher: AnyPublisher<Action, Never>) {
        statePublisher
                .compactMap { $0 }
                .receive(on: DispatchQueue.main)
                .assign(to: &$state)

        actionPublisher
                .compactMap { $0 }
                .receive(on: DispatchQueue.main)
                .assign(to: &$action)
    }
}
*/

private class ObservableModel<State>: ObservableObject {
    @Published var state: State?

    init(statePublisher: AnyPublisher<State, Never>) {
        statePublisher
                .compactMap { $0 }
                .receive(on: DispatchQueue.main)
                .assign(to: &$state)
    }
}


public struct ObservingView<State, Content>: View where Content: View {

    @ObservedObject private var model: ObservableModel<State>

    private let content: (State) -> Content

    public init(statePublisher: AnyPublisher<State, Never>,
                @ViewBuilder content: @escaping (State) -> Content) {
        self.model = ObservableModel(statePublisher: statePublisher)
        self.content = content
    }

    public var body: some View {
        let view: AnyView
        if let state = self.model.state {
            view = AnyView(content(state))
        } else {
            view = AnyView(Text("Render error"))
        }
        return view
    }
}


/*
public struct ObservingView<State, Action, Content>: View where Content: View {

    @ObservedObject private var model: ObservableModel<State, Action>

    private let content: (State, Action?) -> Content

    public init(statePublisher: AnyPublisher<State, Never>,
                actionPublisher: AnyPublisher<Action, Never>,
                @ViewBuilder content: @escaping (State, Action?) -> Content) {
        self.model = ObservableModel(statePublisher: statePublisher,
                actionPublisher: actionPublisher)
        self.content = content
    }

    public var body: some View {
        let view: AnyView
        if let state = self.model.state {
            view = AnyView(content(state, model.action))
        } else {
            view = AnyView(Text("Render error"))
        }
        return view
    }
}
*/

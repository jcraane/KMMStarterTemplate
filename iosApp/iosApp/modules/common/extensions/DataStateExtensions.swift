//
// Created by Jamie Craane on 29/09/2022.
// Copyright (c) 2022 orgName. All rights reserved.
//

import Foundation
import shared
import SwiftUI

class DataStateWrapper<T: AnyObject> {
    let dataState: DataState<T>

    init(_ dataState: DataState<T>) {
        self.dataState = dataState
    }

    func ToSwiftUIView(@ViewBuilder success: @escaping () -> Content) {
        if (self.dataState is DataStateSuccess) {

        }
    }
}

public extension DataState {
    @ViewBuilder
    @objc func ToSwiftUIView() -> some View {

    }
}


/*
 fun <T> DataState<T>.ToComposable(
    onEmpty: @Composable () -> Unit = {},
    onError: @Composable () -> Unit = {},
    onLoading: @Composable (data: T?) -> Unit = {},
    onSuccess: @Composable (data: T) -> Unit = {},
) {
    when (this) {
        is DataState.Empty -> onEmpty()
        is DataState.Error -> onError()
        is DataState.Loading -> onLoading(currentValue)
        is DataState.Success -> onSuccess(value)
    }
}
 */
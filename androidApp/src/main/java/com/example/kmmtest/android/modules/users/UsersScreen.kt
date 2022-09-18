package com.example.kmmtest.android.modules.users

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.ExperimentalLifecycleComposeApi
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.kmmtest.android.extensions.ToComposable
import com.example.kmmtest.users.domain.User
import com.example.kmmtest.users.viewmodel.UsersViewModel
import com.example.kmmtest.util.DataState

@OptIn(ExperimentalLifecycleComposeApi::class)
@Composable
fun UsersScreen(viewModel: UsersViewModel, modifier: Modifier = Modifier) {
    val usersData: DataState<List<User>> by viewModel.users.collectAsStateWithLifecycle(DataState.Empty())

    Box(modifier = modifier) {
        usersData.ToComposable() { users ->
            LazyColumn() {
                items(users) { user ->
                    UserRow(user = user, onUserClicked = {
                        // todo implement
                    })
                }
            }
        }
    }
}

@Composable
private fun UserRow(user: User, onUserClicked: (User) -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .padding(8.dp)
    ) {
        Text(text = user.name)
    }
}
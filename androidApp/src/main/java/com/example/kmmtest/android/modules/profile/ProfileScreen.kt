package com.example.kmmtest.android.modules.profile

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.ExperimentalLifecycleComposeApi
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.kmmstartertemplate.R.*
import com.example.kmmstartertemplate.android.R
import com.example.kmmtest.android.extensions.ToComposable
import com.example.kmmtest.users.domain.User
import com.example.kmmtest.users.viewmodel.UsersViewModel
import com.example.kmmtest.util.DataState

@OptIn(ExperimentalLifecycleComposeApi::class)
@Composable
fun ProfileScreen(
    usersViewModel: UsersViewModel,
    selectedUserId: String?,
    modifier: Modifier = Modifier,
) {
    selectedUserId?.let { userId ->
        usersViewModel.setSelectedUserId(userId)
        val selectedUser by usersViewModel.selectedUser.collectAsStateWithLifecycle(DataState.Empty())
        ProfileScreenContent(selectedUser, modifier)
    }
}

@Composable
private fun ProfileScreenContent(
    selectedUser: DataState<User>,
    modifier: Modifier = Modifier,
) {
    Column(modifier = modifier.padding(16.dp)) {
        selectedUser.ToComposable { user ->
            Row(modifier = Modifier.fillMaxWidth()) {
                Text(text = stringResource(string.l_bottomTab_profile_fields_id))
                Spacer(Modifier.width(8.dp))
                Text(text = user.id)
            }
            Row(modifier = Modifier.fillMaxWidth()) {
                Text(text = stringResource(string.l_bottomTab_profile_fields_name))
                Spacer(Modifier.width(8.dp))
                Text(text = user.name)
            }
        }
    }
}


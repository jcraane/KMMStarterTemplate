package dev.mobilerevolution.starter.common.preferences

import dev.mobilerevolution.starter.common.util.DataState
import dev.mobilerevolution.starter.platform.SharedViewModel
import dev.mobilerevolution.starter.platform.scope
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class PreferencesViewModel(
    private val preferencesRepository: PreferencesRepository,
) : SharedViewModel() {
    private val _preferences = MutableStateFlow<DataState<Preferences>>(DataState.Empty())
    val preferences = _preferences.asStateFlow()

    init {
        scope.launch {
            preferencesRepository.getPreferences().collect {
                _preferences.value = it
            }
        }
    }
}

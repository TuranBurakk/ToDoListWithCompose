package com.turan.todolistwithcompose.presentation.screens.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor() : ViewModel() {

    private val _state = MutableStateFlow(LoginState())
    val state: StateFlow<LoginState> = _state

    fun onEvent(event: LoginEvent) {
        when (event) {
            is LoginEvent.EmailChanged -> {
                _state.value = _state.value.copy(email = event.value)
            }
            is LoginEvent.PasswordChanged -> {
                _state.value = _state.value.copy(password = event.value)
            }
            is LoginEvent.Submit -> {
                login()
            }
        }
    }

    private fun login() {
        viewModelScope.launch {
            _state.value = _state.value.copy(isLoading = true)

            val email = _state.value.email
            val password = _state.value.password

            if (email == "test@test.com" && password == "1234") {
                _state.value = _state.value.copy(isLoading = false, isSuccess = true)
            } else {
                _state.value = _state.value.copy(
                    isLoading = false,
                    errorMessage = "Geçersiz kullanıcı bilgisi"
                )
            }
        }
    }
}

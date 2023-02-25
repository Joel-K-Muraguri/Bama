package com.joel.bama.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseUser
import com.joel.bama.model.auth.AuthService
import com.joel.bama.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val service: AuthService
) : ViewModel() {

    private val _loginFlow = MutableStateFlow<Resource<FirebaseUser>?>(null)
    val loginFlow : StateFlow<Resource<FirebaseUser>?> = _loginFlow

    private val _signupFlow = MutableStateFlow<Resource<FirebaseUser>?>(null)
    val signupFlow : StateFlow<Resource<FirebaseUser>?> = _signupFlow

    val currentUser : FirebaseUser?
        get() = service.currentUser

    init {
        if (service.currentUser != null){
            _loginFlow.value = Resource.Success(service.currentUser!!)
        }
    }

    fun login(email : String, password : String){
        viewModelScope.launch {
            _loginFlow.value = Resource.Loading
            val result = service.login(email, password)
            _loginFlow.value = result
        }
    }

    fun signup(name : String, email : String, password : String){
        viewModelScope.launch {
            _signupFlow.value = Resource.Loading
            val result = service.signUp(email, name, password)
            _signupFlow.value = result

        }
    }

    fun logout(){
        service.logout()
        _loginFlow.value = null
        _signupFlow.value = null
    }
}

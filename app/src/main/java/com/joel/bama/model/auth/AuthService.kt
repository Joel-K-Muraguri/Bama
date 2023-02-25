package com.joel.bama.model.auth

import com.google.firebase.auth.FirebaseUser
import com.joel.bama.utils.Resource

interface AuthService {

    val currentUser : FirebaseUser?
    suspend fun signUp(email : String, name : String, password : String) : Resource<FirebaseUser>
    suspend fun login(email : String, password : String) : Resource<FirebaseUser>
    fun logout()

}
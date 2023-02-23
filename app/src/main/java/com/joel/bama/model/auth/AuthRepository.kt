package com.joel.bama.model.auth

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.UserProfileChangeRequest
import com.joel.bama.utils.Resource
import com.joel.bama.utils.await
import javax.inject.Inject

class AuthRepoImplementation @Inject constructor(
    private val auth : FirebaseAuth
) : AuthService {

    override val currentUser: FirebaseUser?
        get() = auth.currentUser

    override suspend fun signUp(
        email: String,
        name: String,
        password: String
    ): Resource<FirebaseUser> {
        return try {
            val result =  auth.createUserWithEmailAndPassword(email, password).await()
            result.user?.updateProfile(UserProfileChangeRequest.Builder().setDisplayName(name).build())?.await()
            return Resource.Success(result.user!!)
        } catch (e : Exception){
            e.printStackTrace()
            Resource.Failure(e)
        }
    }

    override suspend fun login(email: String, password: String): Resource<FirebaseUser> {
        return try {
            val result =  auth.signInWithEmailAndPassword(email, password).await()
            Resource.Success(result.user!!)
        } catch (e : Exception){
            e.printStackTrace()
            Resource.Failure(e)
        }
    }


    override fun logout() {
        auth.signOut()
    }
}
package com.joel.bama.di

import com.google.firebase.auth.FirebaseAuth
import com.joel.bama.model.auth.AuthRepoImplementation
import com.joel.bama.model.auth.AuthService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideFirebaseAuth() : FirebaseAuth = FirebaseAuth.getInstance()

    @Provides
    fun provideAuthRepo(repo: AuthRepoImplementation) : AuthService = repo

}
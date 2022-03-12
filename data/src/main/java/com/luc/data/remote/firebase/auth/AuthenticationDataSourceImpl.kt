package com.luc.data.remote.firebase.auth

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthException
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.GoogleAuthProvider
import com.luc.common.NetworkStatus
import com.luc.common.model.ProviderType
import com.luc.common.model.UserProfile
import kotlinx.coroutines.tasks.await

class AuthenticationDataSourceImpl(private val firebaseAuth: FirebaseAuth) :
    AuthenticationDataSource {

    override suspend fun signInWithEmailAndPassword(
        email: String,
        password: String
    ): NetworkStatus<UserProfile> {
        return try {
            val data = firebaseAuth
                .signInWithEmailAndPassword(email, password)
                .await()
            if (data.user == null) return NetworkStatus.Error(
                NullPointerException(),
                "The user is null"
            )
            NetworkStatus.Success(data.user!!.asUserProfile())
        } catch (e: FirebaseAuthException) {
            NetworkStatus.Error(e, e.message ?: "An Error occurred")
        }
    }

    override suspend fun signUpWithEmailAndPassword(
        email: String,
        password: String
    ): NetworkStatus<UserProfile> {
        return try {
            val data = firebaseAuth
                .createUserWithEmailAndPassword(email, password)
                .await()
            if (data.user == null) return NetworkStatus.Error(
                NullPointerException(),
                "The user is null"
            )
            NetworkStatus.Success(data.user!!.asUserProfile())
        } catch (e: FirebaseAuthException) {
            NetworkStatus.Error(e, e.message ?: "An Error occurred")
        }
    }

    override suspend fun signInWithGoogle(token: String): NetworkStatus<UserProfile> {
        return try {
            val credentials = GoogleAuthProvider.getCredential(token, null)
            val data = firebaseAuth
                .signInWithCredential(credentials)
                .await()

            if (data.user == null) return NetworkStatus.Error(NullPointerException(), "Null user")

            NetworkStatus.Success(data.user!!.asUserProfile())

        } catch (e: Exception) {
            NetworkStatus.Error(e, e.message ?: "")
        }
    }

    fun checkUserLoggedIn(): UserProfile? {
        return if (firebaseAuth.currentUser == null) {
            null
        } else {
            firebaseAuth.currentUser!!.asUserProfile()
        }
    }

    fun signOut() {
        firebaseAuth.signOut()
    }
}

fun FirebaseUser.asUserProfile(): UserProfile {
    var provider: ProviderType = ProviderType.BASIC
    var userName = ""
    providerData.forEach {
        if (it.providerId == "google.com") provider = ProviderType.GOOGLE
        userName = it.displayName?:"No Username"
    }


    return UserProfile(this.uid, userName, this.email ?: "No email", this.photoUrl, provider)

}

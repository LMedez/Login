package com.luc.common.model

import android.net.Uri
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class UserProfile(
    val uId: String = "",
    val userName: String = "",
    val email: String = "",
    val photoUri: Uri?,
    val providerType: ProviderType = ProviderType.BASIC
) : Parcelable
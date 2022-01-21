package com.luc.common

sealed class NetworkStatus <out T> {
    data class Success<out T>(val data : T) : NetworkStatus<T>()
    data class Error<out T>(val exception: Exception?, val message: String) : NetworkStatus<T>()
}
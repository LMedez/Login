package com.luc.basicstartmodularappandroid.utils

import java.util.*


fun String.capitalizeFirstChar() = replaceFirstChar {
    if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString()
}

fun String.capitalizeWords(): String = split(" ").joinToString(" ") { it.capitalizeFirstChar() }
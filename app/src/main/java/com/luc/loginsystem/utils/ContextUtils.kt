package com.luc.loginsystem.utils

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.Drawable
import androidx.annotation.AttrRes
import androidx.annotation.ColorInt
import androidx.annotation.DrawableRes
import androidx.appcompat.content.res.AppCompatResources

@ColorInt
@SuppressLint("Recycle")
fun Context.themeColor(
    @AttrRes themeAttrId: Int
): Int {
    return obtainStyledAttributes(
        intArrayOf(themeAttrId)
    ).getColor(0, Color.MAGENTA)
}

fun Context.getDrawableOrNull(@DrawableRes id: Int?): Drawable? {
    return if (id == null || id == 0) null else AppCompatResources.getDrawable(this, id)
}
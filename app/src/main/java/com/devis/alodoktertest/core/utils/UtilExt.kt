package com.devis.alodoktertest.core.utils

import android.app.Activity
import android.graphics.Point
import android.util.Patterns

/**
 * Created by devis on 01/07/20
 */

fun String.isValidEmail(): Boolean {
    return Patterns.EMAIL_ADDRESS.matcher(this).matches()
}

fun String.isValidPassword(): Boolean {
    return this.length in 6..12
}

fun getScreenWidth(activity: Activity): Int {
    val size = Point()
    activity.windowManager.defaultDisplay.getSize(size)
    return size.x
}

fun getScreenHeight(activity: Activity): Int {
    val size = Point()
    activity.windowManager.defaultDisplay.getSize(size)
    return size.y
}
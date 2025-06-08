package com.lafimsize.mindscope.util

import android.app.Activity
import android.content.Context
import android.content.ContextWrapper

/**
 * a context can also be a context wrapper (for example: the context inside Compose).
 * Therefore, (as ComponentActivity, Activity...) cannot be cast correctly.
 * If we can control it with ext and convert it to activity, casting will work correctly.
 */

fun Context.findActivity() : Activity{

    var context = this

    while (context is ContextWrapper){
        if (context is Activity) return context
        context = context.baseContext
    }

    throw IllegalStateException("Activity not found in context chain!")
}
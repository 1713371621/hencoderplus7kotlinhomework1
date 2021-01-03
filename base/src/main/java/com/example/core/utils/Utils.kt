@file:JvmName("KotlinUtils")

package com.example.core.utils

import android.content.Context
import android.content.SharedPreferences
import android.content.res.Resources
import android.util.TypedValue
import android.widget.Toast
import com.example.core.BaseApplication.Companion.currentApplication
import com.example.core.R

private val context: Context = currentApplication()

val Float.dp
  get(): Float = TypedValue.applyDimension(
      TypedValue.COMPLEX_UNIT_DIP,
      this,
      Resources.getSystem().displayMetrics
  )

fun toast(string: String) {
  toast(string, Toast.LENGTH_SHORT)
}

fun toast(string: String, duration: Int) {
  Toast.makeText(context, string, duration).show()
}

private val SP: SharedPreferences? = context.getSharedPreferences(context.getString(R.string.app_name), Context.MODE_PRIVATE)

fun save(key: String, value: String) {
  SP?.edit()?.putString(key, value)?.apply()
}

val String.value
  get(): String? {
    return SP?.getString(this, null)
  }
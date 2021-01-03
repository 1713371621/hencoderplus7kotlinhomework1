package com.example.core

import android.view.View
import android.widget.TextView
import androidx.annotation.IdRes
import androidx.recyclerview.widget.RecyclerView

abstract class BaseViewHolder(private val baseItemView: View) : RecyclerView.ViewHolder(baseItemView) {

  private val viewHashMap: MutableMap<Int, View> = HashMap()

  protected fun <T : View> getView(@IdRes id: Int): T? {
    return viewHashMap[id]?.let {
      it as T
    } ?: let {
      val view: T = baseItemView.findViewById(id)
      viewHashMap[id] = view
      view
    }
  }

  protected fun setText(@IdRes id: Int, text: String) {
    getView<TextView>(id)?.text = text
  }
}
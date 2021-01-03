package com.example.hencoderpluskotlinhomework1.widget

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.util.TypedValue
import android.view.Gravity
import androidx.appcompat.widget.AppCompatTextView
import com.example.core.utils.dp
import com.example.hencoderpluskotlinhomework1.R
import java.util.*

class CodeView(context: Context, attrs: AttributeSet) : AppCompatTextView(context, attrs) {

  private val newPaint: Paint = Paint()

  private val codeList = arrayOf(
      "kotlin",
      "android",
      "java",
      "http",
      "https",
      "okhttp",
      "retrofit",
      "tcp/ip"
  )

  init {
    setTextSize(TypedValue.COMPLEX_UNIT_SP, 18f)
    gravity = Gravity.CENTER
    setBackgroundColor(getContext().getColor(R.color.purple_200))
    setTextColor(Color.WHITE)

    newPaint.isAntiAlias = true
    newPaint.style = Paint.Style.STROKE
    newPaint.color = getContext().getColor(R.color.purple_500)
    newPaint.strokeWidth = 6f.dp

    updateCode()
  }

  fun updateCode() {
    val random = Random().nextInt(codeList.size)
    val code = codeList[random]
    text = code
  }


  override fun onDraw(canvas: Canvas) {
    canvas.drawLine(0f, height.toFloat(), width.toFloat(), 0f, newPaint)
    super.onDraw(canvas)
  }
}
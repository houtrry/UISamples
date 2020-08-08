package com.houtrry.chartlibrary

import android.content.res.Resources
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.util.TypedValue

/**
 * @author: houtrry
 * @time: 2020/8/8
 * @desc:
 */
data class PieItemDataBean(var color: Int, var text: String, var percent: Float)

val Float.sp: Float get() = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, this, Resources.getSystem().displayMetrics)
val Int.sp: Float get() = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, this.toFloat(), Resources.getSystem().displayMetrics)
val Float.dp: Float get() = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, this, Resources.getSystem().displayMetrics)
val Int.dp: Float get() = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, this.toFloat(), Resources.getSystem().displayMetrics)
val String.color: Int get() = Color.parseColor(this)


fun Paint.getTextWidth(text: String): Float {
    return this.measureText(text)
}

fun Paint.getTextHeight(text: String): Int {
    val rect = Rect()
    this.getTextBounds(text, 0, text.length, rect)
    return rect.height()
}
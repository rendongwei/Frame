package com.don.frame.extend

import android.graphics.Paint
import android.graphics.Typeface
import android.widget.TextView

// 取文本
fun TextView.getContent(): String {
    return text.toString().trim()
}

// 判断是否为空
fun TextView.isNullOrEmpty(): Boolean {
    return getContent().isNullOrEmpty()
}

// 设置默认
fun TextView.setNormal(): TextView {
    setTypeface(typeface, Typeface.NORMAL)
    return this
}

// 设置加粗
fun TextView.setBold(isBold: Boolean): TextView {
    paint.isFakeBoldText = isBold
    return this
}

// 设置加粗
fun TextView.setBold(): TextView {
    paint.flags = paint.flags or Paint.FAKE_BOLD_TEXT_FLAG
    return this
}

// 设置斜体
fun TextView.setItalic(): TextView {
    setTypeface(typeface, Typeface.ITALIC)
    return this
}

// 设置粗斜体
fun TextView.setBoldItalic(): TextView {
    setTypeface(typeface, Typeface.BOLD_ITALIC)
    return this
}

// 设置删除线
fun TextView.setDeleteLine(): TextView {
    paint.flags = paint.flags or Paint.STRIKE_THRU_TEXT_FLAG
    return this
}

// 设置下划线
fun TextView.setUnderLine(): TextView {
    paint.flags = paint.flags or Paint.UNDERLINE_TEXT_FLAG
    return this
}

// 设置字体
fun TextView.setFont(font: String): TextView {
    typeface = Typeface.createFromAsset(context.assets, font)
    return this
}

// 获取文本宽度
fun TextView.textWidth(): Float {
    return textWidth(getContent())
}

// 获取文本宽度
fun TextView.textWidth(text: String): Float {
    return paint.measureText(text)
}
package ru.fefu.activitytracker

import android.text.TextPaint
import android.text.style.ClickableSpan

abstract class NoUnderLineClickableSpan : ClickableSpan() {
    override fun updateDrawState(ds: TextPaint) {
        super.updateDrawState(ds)
        ds.isUnderlineText = false
    }
}
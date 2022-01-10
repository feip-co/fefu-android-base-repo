package ru.fefu.activitytracker

import android.graphics.Color
import android.text.*
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.view.View
import android.widget.TextView

object Utils {
    fun makeLinks(textView: TextView, vararg links: Pair<String, View.OnClickListener>) {
        val spannableString = SpannableString(textView.text)
        var startIndexOfLink = -1
        for (link in links) {
            val clickableSpan = object : ClickableSpan() {
                override fun updateDrawState(textPaint: TextPaint) {
                    textPaint.color = Color.parseColor("#4B09F3")
                    textPaint.isUnderlineText = true
                }

                override fun onClick(view: View) {
                    Selection.setSelection((view as TextView).text as Spannable, 0)
                    view.invalidate()
                    link.second.onClick(view)
                }
            }
            startIndexOfLink = textView.text.toString().indexOf(link.first, startIndexOfLink + 1)
            spannableString.setSpan(
                clickableSpan, startIndexOfLink, startIndexOfLink + link.first.length,
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
            )
        }

        with(textView) {
            movementMethod = LinkMovementMethod.getInstance()
            setText(spannableString, TextView.BufferType.SPANNABLE)
        }
    }
}
package com.example.app.models

import com.example.app.views.AbstractCard

data class MyActivityData(
    val distance: String,
    val duration: String,
    val type: String,
    val comment: String? = null,
    val date: String
): AbstractCard()
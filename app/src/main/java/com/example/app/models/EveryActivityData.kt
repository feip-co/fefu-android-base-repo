package com.example.app.models

import com.example.app.views.AbstractCard

class EveryActivityData (
    val distance: String,
    val username: String,
    val duration: String,
    val type: String,
    val comment: String? = null,
    val date: String
): AbstractCard()
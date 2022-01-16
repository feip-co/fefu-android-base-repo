package ru.fefu.hw

import ru.fefu.hw.CardAbstract

data class MyActivityData(
    val distance: String,
    val duration: String,
    val type: String,
    val comment: String? = null,
    val date: String
): CardAbstract()
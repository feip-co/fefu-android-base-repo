package ru.fefu.hw

import ru.fefu.hw.CardAbstract

class UsersActivityData(
    val distance: String,
    val username: String,
    val duration: String,
    val type: String,
    val comment: String? = null,
    val date: String
): CardAbstract()
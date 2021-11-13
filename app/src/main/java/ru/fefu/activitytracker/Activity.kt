package ru.fefu.activitytracker

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import org.joda.time.DateTime

@Parcelize
data class Activity(
    val id: Int,
    val title: String,
    val startDateTime: DateTime,
    val endDateTime: DateTime,
    val distance: Int,
    val username: String,
    val comment: String? = null,
) : Parcelable

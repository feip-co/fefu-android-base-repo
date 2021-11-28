package com.example.app.views.viewholders

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.app.R
import com.example.app.models.DateActivityData
import com.example.app.views.AbstractCard

class DateActivityHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    private val ivDate: TextView = itemView.findViewById(R.id.date_activity_card_date)

    fun bind(item: AbstractCard) {
        item as DateActivityData
        ivDate.text = item.date
    }
}
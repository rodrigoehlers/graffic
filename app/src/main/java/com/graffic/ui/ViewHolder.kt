package com.graffic.ui

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item.view.*

class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val tvNumber = view.number
    val tvTimestamp = view.timestamp

}
package com.graffic.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.graffic.R
import com.graffic.data.Config

class RecyclerAdapter(private val items: ArrayList<Config>, private val context: Context) :
    RecyclerView.Adapter<ViewHolder>() {

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder?.tvNumber?.text = items[position].number.toString()
        holder?.tvTimestamp?.text = items[position].timestamp.toString()
    }
}



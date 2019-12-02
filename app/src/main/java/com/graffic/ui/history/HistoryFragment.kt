package com.graffic.ui.history

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.graffic.R
import com.graffic.data.ConfigHistory
import com.graffic.ui.RecyclerAdapter
import kotlinx.android.synthetic.main.fragment_history.*

class HistoryFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_history, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val configHistory = ConfigHistory(context as Context)
        history_list.adapter =
            RecyclerAdapter(ArrayList(configHistory.getConfigHistory()), this.requireContext())
        history_list.layoutManager = LinearLayoutManager(context);
    }
}
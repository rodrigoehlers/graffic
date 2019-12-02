package com.graffic.ui.history

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.graffic.R
import com.graffic.data.Config
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
        val configs = ArrayList<Config>()
        configs.add(Config(1, "00491727917021", 2, 120, 120, System.currentTimeMillis()))
        configs.add(Config(2, "004917651325245", 4, 60, 30, System.currentTimeMillis()))
        history_list.adapter = RecyclerAdapter(configs, this.requireContext())
        history_list.layoutManager = LinearLayoutManager(context);
    }
}
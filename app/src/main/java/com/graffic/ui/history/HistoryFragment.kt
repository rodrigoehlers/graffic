package com.graffic.ui.history

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
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
        configs.add(Config(1, 1, 1, 1, 1, 1))
        configs.add(Config(2, 2, 2, 2, 2, 2))
        history_list.adapter = RecyclerAdapter(configs, this.requireContext())
    }
}
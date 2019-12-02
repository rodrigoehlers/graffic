package com.graffic.ui.history

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.graffic.R
import com.graffic.data.Config
import com.graffic.ui.RecyclerAdapter
import kotlinx.android.synthetic.main.fragment_history.*

class HistoryFragment : Fragment() {

    private lateinit var historyViewModel: HistoryViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        historyViewModel =
            ViewModelProviders.of(this).get(HistoryViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_custom, container, false)
<<<<<<< HEAD






=======
>>>>>>> 198bccf5323737c914e7c2e235527a8f6c901fb4

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val configs = ArrayList<Config>()
        configs.add(Config(1, 1, 1, 1, 1, 1))
        configs.add(Config(2, 2, 2, 2, 2, 2))
        history_list.adapter = RecyclerAdapter(configs, this.requireContext())
    }
}
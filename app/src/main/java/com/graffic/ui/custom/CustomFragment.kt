package com.graffic.ui.custom

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.graffic.CallService
import com.graffic.R
import com.graffic.data.Config
import com.graffic.data.ConfigHistory
import kotlinx.android.synthetic.main.fragment_custom.*
import kotlinx.android.synthetic.main.item.*

class CustomFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_custom, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val cs = CallService(context)
        super.onViewCreated(view, savedInstanceState)
        start.setOnClickListener {
            val config = getConfig()
            val configHistory = ConfigHistory(context as Context)
            configHistory.addConfig(config)
            cs.start(config)
        }
    }

    fun getConfig(): Config {
        return Config(
            number.text.toString(),
            Integer.parseInt(count.text.toString()),
            Integer.parseInt(duration.text.toString()),
            Integer.parseInt(pause.text.toString()),
            System.currentTimeMillis()
        )
    }
}
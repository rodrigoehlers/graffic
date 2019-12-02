package com.graffic.ui.custom

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.graffic.CallService
import com.graffic.Config
import com.graffic.R
import kotlinx.android.synthetic.main.fragment_custom.*

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
            cs.start(getConfig())
        }
    }

    private fun getConfig(): Config {
        return Config(
            phone.text.toString(),
            Integer.parseInt(count.text.toString()),
            Integer.parseInt(duration.text.toString()),
            Integer.parseInt(pause.text.toString()),
            System.currentTimeMillis()
        )
    }
}
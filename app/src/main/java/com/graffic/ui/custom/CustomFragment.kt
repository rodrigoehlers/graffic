package com.graffic.ui.custom

import android.annotation.SuppressLint
import android.content.Intent
import android.content.IntentFilter
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

    @SuppressLint("MissingPermission")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val cs = CallService()
        super.onViewCreated(view, savedInstanceState)
        val intentFilter = IntentFilter(Intent.ACTION_CALL)
        context?.registerReceiver(cs, intentFilter)
        start.setOnClickListener {
            cs.start(context, getConfig())

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
package com.graffic.ui.answer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.graffic.R
import kotlinx.android.synthetic.main.fragment_answer_mode.*

class AnswerModeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_answer_mode, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var enabled = false
        toggle.setOnClickListener {
            enabled = !enabled
            toggle.setText(if (enabled) R.string.button_disable else R.string.button_enable)
            toggle.backgroundTintList =
                (resources.getColorStateList(if (enabled) R.color.disabled_red else R.color.enabled_green))
            status.setText(if (enabled) R.string.text_view_enabled else R.string.text_view_disabled)

        }
    }
}
package com.graffic.ui.answer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.graffic.R

class AnswerModeFragment : Fragment() {

    private lateinit var answerModeViewModel: AnswerModeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        answerModeViewModel =
            ViewModelProviders.of(this).get(AnswerModeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_notifications, container, false)
        val textView: TextView = root.findViewById(R.id.text_notifications)
        answerModeViewModel.text.observe(this, Observer {
            textView.text = it
        })
        return root
    }
}
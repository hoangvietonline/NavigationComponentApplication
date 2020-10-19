package com.hoangviet.navigationcomponentapplication.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.hoangviet.navigationcomponentapplication.R

class OneFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_blank, container, false)
        view.findViewById<Button>(R.id.btnClick).setOnClickListener {
            findNavController().navigate(R.id.action_global_fragmentNotifications)
        }
        val name = arguments?.getString("userName") ?: "HAHAHAHAHAHAHA"
        val tvOne = view.findViewById<TextView>(R.id.tvOne)
        tvOne.text = name
        return view
    }

    companion object {
        fun newInstance(param1: String, param2: String) =
            OneFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}
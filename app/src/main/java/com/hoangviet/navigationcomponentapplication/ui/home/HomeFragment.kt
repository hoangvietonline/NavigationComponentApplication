package com.hoangviet.navigationcomponentapplication.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.hoangviet.navigationcomponentapplication.R
import kotlinx.android.synthetic.main.fragment_home.view.*

class HomeFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        root.findViewById<Button>(R.id.btnDashboard).setOnClickListener {
            val action = HomeFragmentDirections.actionFragmentHomeToFragmentDashboard("I LOVE YOU!!!")
            root.findNavController().navigate(action)
        }
        root.findViewById<Button>(R.id.btnNotify).setOnClickListener {
            root.findNavController().navigate(R.id.action_fragmentHome_to_fragmentNotifications)
        }
        root.webView.loadUrl("file:///android_asset/click.html")
        return root
    }
}
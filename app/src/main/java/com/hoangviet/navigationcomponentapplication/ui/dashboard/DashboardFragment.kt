package com.hoangviet.navigationcomponentapplication.ui.dashboard

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.core.app.NotificationCompat
import androidx.fragment.app.Fragment
import androidx.navigation.NavDeepLinkBuilder
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.hoangviet.navigationcomponentapplication.R
import kotlinx.android.synthetic.main.fragment_dashboard.view.*

class DashboardFragment : Fragment() {
    private val args: DashboardFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_dashboard, container, false)
        root.findViewById<Button>(R.id.btnOne).setOnClickListener {
            val bundle = Bundle()
            bundle.putString("userName", "Cai gi dok kakakakakaka hehehe")
            root.findNavController().navigate(R.id.action_fragmentDashboard_to_fragmentOne, bundle)
        }
        val key = args.Key
        root.findViewById<TextView>(R.id.tvDashboard).text = key

        root.btnClickIntent.setOnClickListener {
            onExplicitDeepLink()
        }
        return root
    }

    private fun onExplicitDeepLink() {
        val pendingIntent = NavDeepLinkBuilder(this.requireContext())
            .setGraph(R.navigation.mobile_navigation)
            .setDestination(R.id.fragmentHome)
            .setArguments(null)
            .createPendingIntent()
        val notificationManager =
            requireContext().getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            notificationManager.createNotificationChannel(
                NotificationChannel(
                    channelId, "Deep Links", NotificationManager.IMPORTANCE_HIGH
                )
            )
        }
        val builder = NotificationCompat.Builder(
            requireContext(), channelId
        )
            .setContentTitle("Navigation")
            .setContentText("Deep link to Android")
            .setSmallIcon(R.drawable.ic_dashboard_black_24dp)
            .setContentIntent(pendingIntent)
            .setAutoCancel(true)
        notificationManager.notify(0, builder.build())
    }
}

const val channelId = "channel_id"
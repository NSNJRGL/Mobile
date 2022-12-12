package com.example.cvapp.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.cvapp.ui.dashboard.DashboardFragment
import com.example.cvapp.ui.home.HomeFragment
import com.example.cvapp.ui.notifications.NotificationsFragment

class MyViewAdapter(fm: FragmentManager, lc: Lifecycle) : FragmentStateAdapter(fm,lc) {
    override fun getItemCount(): Int = 4
    override fun createFragment(position: Int): Fragment {
        return   when(position){
            0-> HomeFragment()
            1-> DashboardFragment()
            2-> NotificationsFragment()
            else-> Fragment()
        }
    }
}
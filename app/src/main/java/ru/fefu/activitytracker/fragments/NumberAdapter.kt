package ru.fefu.activitytracker.fragments


import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class NumberAdapter (fragment: ActivityFragment): FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int = 2
    override fun createFragment(position: Int): Fragment {
        val fragment = if(position ==0 )ActivityMyFragment() else ActivityUsersFragment()
        return fragment
    }
}

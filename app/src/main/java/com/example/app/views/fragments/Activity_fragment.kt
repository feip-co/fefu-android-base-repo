package com.example.app.views.fragments

import android.app.Activity
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.example.app.R
import com.example.app.databinding.FragmentActivityFragmentBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class Activity_fragment : Fragment(), ParentFragmentManager {
    private lateinit var activityCollectionAdapter: ActivityCollectionAdapter
    private lateinit var viewPager: ViewPager2
    private lateinit var tabLayout: TabLayout

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_activity_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        activityCollectionAdapter = ActivityCollectionAdapter(this)
        viewPager = view.findViewById(R.id.view_pager2)
        viewPager.adapter = activityCollectionAdapter
        tabLayout = view.findViewById(R.id.tab_layout)
        TabLayoutMediator(
            tabLayout,
            viewPager
        ) { tab, position ->
            tab.text = when (position) {
                0 -> "Моя"
                else -> "Пользователей"
            }
        }
            .attach()

    }

    companion object {
        @JvmStatic
        fun newInstance() = Activity_fragment()
    }

    override fun getActivitiesFragmentManager(): FragmentManager =
        (parentFragment as ParentFragmentManager)
            .getActivitiesFragmentManager()
    }

    class ActivityCollectionAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
        override fun getItemCount(): Int = 2

        override fun createFragment(position: Int): Fragment {
            return when (position) {
                0 -> My_fragment()
                else -> Every_fragment()
            }
        }
}
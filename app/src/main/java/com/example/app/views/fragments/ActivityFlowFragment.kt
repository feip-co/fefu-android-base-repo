package com.example.app.views.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.app.R

class ActivityFlowFragment : Fragment(R.layout.fragment_activity_flow), ParentFragmentManager {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_activity_flow, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        if (savedInstanceState == null) {
            childFragmentManager.beginTransaction().apply {
                add(
                    R.id.activity_flow_container,
                    Activity_fragment.newInstance(),
                    "activities"
                )
                commit()
            }
        }
    }
    companion object {
        @JvmStatic
        fun newInstance() = ActivityFlowFragment()
    }

    override fun getActivitiesFragmentManager(): FragmentManager = childFragmentManager
}
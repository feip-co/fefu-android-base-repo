package ru.fefu.hw

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.FragmentManager

class ActivityFlow : Fragment(R.layout.activity_flow), Parent {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.activity_flow, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        if (savedInstanceState == null) {
            childFragmentManager.beginTransaction().apply {
                add(
                    R.id.activity_flow_container,
                    CollectionAdapterFragment.newInstance(),
                    "activities"
                )
                commit()
            }

            val btnToStartNewActivity: ImageView = view.findViewById(R.id.btn_to_start_new_activity)

        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = ActivityFlow()
    }

    override fun getActivitiesFragmentManager(): FragmentManager = childFragmentManager
}
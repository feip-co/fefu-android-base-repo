package com.example.app.views.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.app.R
import com.example.app.databinding.FragmentMyFragmentBinding
import com.example.app.models.DateActivityData
import com.example.app.models.MyActivityData
import com.example.app.views.adapters.MyActivityAdapter


class My_fragment : Fragment(){
    private lateinit var recyclerView: RecyclerView
    private val dataList = listOf(
        DateActivityData("Yesterday"),
        MyActivityData(
            distance = "14.32 km",
            duration = "2 hours 46 minutes",
            type = "Surfing",
            date = "14 hours ago",
        ),
        DateActivityData("May 2022"),
        MyActivityData(
            distance = "1000 m",
            duration = "60 minutes",
            type = "Surfing",
            date = "29.05.2022",
        ),
        DateActivityData("May 2022"),
        MyActivityData(
            distance = "2 km",
            duration = "60 minutes",
            type = "running",
            date = "28.05.2022",
        ),
        DateActivityData("May 2022"),
        MyActivityData(
            distance = "10 km",
            duration = "4 hours",
            type = "Hiking",
            date = "25.05.2022",
        )
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_my_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.my_activity_recycler)
        recyclerView.layoutManager = LinearLayoutManager(context)
        val adapter = MyActivityAdapter (
            dataList
        )
        recyclerView.adapter = adapter
        adapter.setItemClickListener {
            (parentFragment as ParentFragmentManager).getActivitiesFragmentManager().beginTransaction().apply {
                replace(
                    R.id.activity_flow_container,
                    DetailedActivityFragment.newInstance(),
                    "detailedActivity"
                )
                addToBackStack(null)
                commit()
            }
        }
    }

    companion object {
        fun newInstance() = My_fragment
    }
}
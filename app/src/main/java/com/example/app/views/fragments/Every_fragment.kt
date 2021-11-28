package com.example.app.views.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.app.R
import com.example.app.models.DateActivityData
import com.example.app.models.EveryActivityData
import com.example.app.views.adapters.EveryActivityAdapter

class Every_fragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private val dataList = listOf(
        DateActivityData("Yesterday"),
        EveryActivityData(
            distance = "14.32 km",
            duration = "2 hours 46 minutes",
            type = "Surfing",
            date = "14 hours ago",
            comment = "I'm Flash",
            username = "@van_dorkholme"
        ),
        EveryActivityData(
            distance = "10 km",
            duration = "2 hours",
            type = "Cycling",
            date = "20 hours ago",
            username = "@tecnhiquepasha"
        ),
        DateActivityData("May 2022"),
        EveryActivityData(
            distance = "6 km",
            duration = "3 hours",
            type = "Hiking",
            date = "May 20",
            username = "@morgen_shtern"
        )
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_every_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.users_activity_recycler)
        recyclerView.layoutManager = LinearLayoutManager(context)
        val adapter = EveryActivityAdapter(
            dataList
        )
        recyclerView.adapter = adapter
        adapter.setItemClickListener {
            (parentFragment as ParentFragmentManager).getActivitiesFragmentManager().beginTransaction().apply {
                replace(
                    R.id.activity_flow_container,
                    DetailedActivityFragment.newInstance(
                        username = (dataList[it] as EveryActivityData).username,
                        commentText = (dataList[it] as EveryActivityData).comment,
                        isMyActivity =  false
                    )
                )
                addToBackStack(null)
                commit()
            }
        }
    }

    companion object {
        fun newInstance() = Every_fragment
    }
}
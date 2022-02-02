package ru.fefu.activitytracker.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import ru.fefu.activitytracker.dataclasses.ActivityData
import ru.fefu.activitytracker.dataclasses.DateData
import ru.fefu.activitytracker.R
import ru.fefu.activitytracker.dataclasses.UserActivityData
import ru.fefu.activitytracker.adapters.ActivitiesListRecyclerAdapter
import ru.fefu.activitytracker.databinding.FragmentTheirActivitiesBinding
import java.time.LocalDateTime

class TheirActivitiesFragment : Fragment() {
    private var _binding: FragmentTheirActivitiesBinding? = null
    private val binding get() = _binding!!
    private lateinit var items: MutableList<ActivityData>
    val activities = listOf<UserActivityData>()
    
    val map = mapOf(1 to "Январь", 2 to "Февраль", 3 to "Март",
        4 to "Апрель", 5 to "Май", 6 to "Июнь",
        7 to "Июль", 8 to "Август", 9 to "Сентябрь",
        10 to "Октябрь", 11 to "Ноябрь", 12 to "Декабрь")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTheirActivitiesBinding.inflate(inflater, container, false)
        return binding.root
    }
    val data_activities = mutableListOf<Any>()
    private fun fill_date(activities: List<UserActivityData>) {
        val cur = LocalDateTime.now()
        var date = DateData("")
        for (activity in activities) {
            if (cur.year == activity.endDate.year &&
                cur.monthValue == activity.endDate.monthValue &&
                cur.dayOfMonth == activity.endDate.dayOfMonth) {
                if (date.Date != "Сегодня") {
                    date = DateData("Сегодня")
                    data_activities.add(date)
                }
            }
            else {
                if (date.Date != map.get(activity.endDate.monthValue) + ' ' + activity.endDate.year.toString()  + "года") {
                    date = DateData(map.get(activity.endDate.monthValue) + ' '+activity.endDate.year.toString() + "года")
                    data_activities.add(date)
                }
            }
            Log.d("TAG", cur.hour.toString())
            data_activities.add(activity)
        }
    }
    private val adapter = ActivitiesListRecyclerAdapter(data_activities)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fill_date(activities)
        val recycleView = binding.theirRecyclerView
        recycleView.layoutManager = LinearLayoutManager(requireContext())
        recycleView.adapter = adapter
        adapter.setItemClickListener {position: Int ->
            findNavController().navigate(R.id.action_workoutFragment_to_theirActivityDetailsFragment)
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

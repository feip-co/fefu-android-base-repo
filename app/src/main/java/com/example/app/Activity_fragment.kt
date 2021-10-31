package com.example.app

import android.app.Activity
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.app.databinding.FragmentActivityFragmentBinding
import com.google.android.material.tabs.TabLayoutMediator

class Activity_fragment : Fragment(R.layout.fragment_activity_fragment) {
    private var _binding: FragmentActivityFragmentBinding? = null
    private val binding get()  = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentActivityFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.viewPager2.adapter = FragmentAdapter(this)

        TabLayoutMediator(binding.tabLayout, binding.viewPager2) {tab, position ->
            if (position == 0)
                tab.text = "Мои"
            else tab.text = "Пользователей"
        }.attach()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        const val tag = "activity_fragment"

        fun newInstance() : Activity_fragment {
            val fragment = Activity_fragment()
            fragment.arguments = Bundle()
            return fragment
        }
    }
}
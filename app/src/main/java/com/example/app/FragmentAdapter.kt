package com.example.app

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class FragmentAdapter(fragment : Activity_fragment) : FragmentStateAdapter(fragment){
    override fun getItemCount(): Int {
        return 2;
    }

    override fun createFragment(position: Int): Fragment {
        if (position == 0) {
            return My_fragment.newInstance()
        }
        else {
            return Every_fragment.newInstance()
        }
    }

}
package com.example.app.views.fragments

import androidx.fragment.app.FragmentManager
interface ParentFragmentManager {
    fun getActivitiesFragmentManager() : FragmentManager
}
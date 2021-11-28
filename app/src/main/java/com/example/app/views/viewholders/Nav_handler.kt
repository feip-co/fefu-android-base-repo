package com.example.app.views.viewholders

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.app.R
import com.example.app.views.fragments.ActivityFlowFragment
import com.example.app.views.fragments.Profile_fragment
import com.google.android.material.bottomnavigation.BottomNavigationView


class Nav_handler : AppCompatActivity() {
    private var bottomNavigation: BottomNavigationView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNavigation = findViewById(R.id.nav)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction().apply {
                add(
                    R.id.fr_container,
                    ActivityFlowFragment.newInstance(),
                "activity_fragment"
                )
                commit()
            }
        }
        bottomNavigationSelector()
    }

    private fun bottomNavigationSelector() {
        bottomNavigation?.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.activity -> {
                    val activityFragment =
                        supportFragmentManager.findFragmentByTag("activity_fragment")
                    val profileFragment =
                        supportFragmentManager.findFragmentByTag("profile_fragment")
                    supportFragmentManager.beginTransaction().apply {
                        if (activityFragment != null) {
                            show(activityFragment)
                        } else
                            add(
                                R.id.fr_container,
                                ActivityFlowFragment.newInstance(),
                                "activity_fragment"
                            )
                        if (profileFragment != null)
                            hide(profileFragment)
                        commit()
                    }
                    true
                }
                R.id.profile -> {
                    val activityFragment =
                        supportFragmentManager.findFragmentByTag("activity_fragment")
                    val profileFragment =
                        supportFragmentManager.findFragmentByTag("profile_fragment")
                    supportFragmentManager.beginTransaction().apply {
                        if (profileFragment != null) {
                            show(profileFragment)
                        } else
                            add(
                                R.id.fr_container,
                                Profile_fragment.newInstance(),
                                "profile_fragment"
                            )
                        if (activityFragment != null)
                            hide(activityFragment)
                        commit()
                    }
                    true
                }
                else ->
                    false
                }
            }
        }
}


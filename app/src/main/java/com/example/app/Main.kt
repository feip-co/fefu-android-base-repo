package com.example.app

import android.app.Activity
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.app.databinding.ActivityMainBinding

class Main : AppCompatActivity(R.layout.activity_main) {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setActivity(savedInstanceState)
        setNavHandler()
    }
    private fun setActivity(savedInstanceState: Bundle?) {
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction().apply {
                add(
                    R.id.fr_container,
                    Activity_fragment.newInstance(),
                    Activity_fragment.tag
                )
                commit()
            }
        }
    }
    private fun setNavHandler() {
        val tabFragments = listOf(
            TabFragment(R.id.activity, getFragment(Activity_fragment.tag),
                Activity_fragment.tag
        ),
            TabFragment(R.id.profile, getFragment(Profile_fragment.tag),
            Profile_fragment.tag
            )
        )
        val nav_handler = Nav_handler(tabFragments, supportFragmentManager)
            binding.nav.setOnItemSelectedListener() {item -> nav_handler.switchFragments(item.itemId)
            true
        }
    }
    private fun getFragment(tag: String) : Fragment {
        return supportFragmentManager.findFragmentByTag(tag)
            ?: when (tag) {
                Activity_fragment.tag -> Activity_fragment.newInstance()
                Profile_fragment.tag -> Profile_fragment.newInstance()
                else -> return Fragment()
            }
    }
}
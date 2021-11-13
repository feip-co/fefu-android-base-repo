package ru.fefu.activitytracker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import androidx.fragment.app.FragmentContainerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import ru.fefu.activitytracker.fragments.ActivityFragment
import ru.fefu.activitytracker.fragments.ProfileFragment

class FourthActivity : AppCompatActivity() {

    private var tab: Int = 1;
    private lateinit var bottom_nav: BottomNavigationView;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fourth)
        if (savedInstanceState != null) {
            bottom_nav.selectedItemId = savedInstanceState.getInt("tabs", 1)
        };
        else {
            supportFragmentManager.beginTransaction().apply {
                add(R.id.fragmentContainer, ActivityFragment(), "activity")
                commit()
            }
        }
        bottom_nav = findViewById<BottomNavigationView>(R.id.buttonNavigation)
        bottom_nav.setOnItemSelectedListener {
            if (it.itemId == R.id.activity_navigation && bottom_nav.selectedItemId == R.id.profile_navigation) {
                supportFragmentManager.beginTransaction().apply {
                    var f = supportFragmentManager.findFragmentByTag("activity")
                    if (f != null) this.show(f)
                    f = supportFragmentManager.findFragmentByTag("profile")
                    if (f != null) this.hide(f)
                    addToBackStack("activity")
                    commit()
                }
            } else if (it.itemId == R.id.profile_navigation && bottom_nav.selectedItemId == R.id.activity_navigation) {
                supportFragmentManager.beginTransaction().apply {
                    var fragment = supportFragmentManager.findFragmentByTag("activity")
                    if (fragment != null)
                        this.hide(fragment)
                    fragment = supportFragmentManager.findFragmentByTag("profile")
                    if (fragment == null) add(
                        R.id.fragmentContainer,
                        ProfileFragment(),
                        "profile"
                    )
                    else this.show(fragment)
                    addToBackStack("profile")
                    commit()
                }
            }
            true
        }

    }

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
        outState.putInt("tabs", bottom_nav.selectedItemId)
    }
}
package com.ppb.navbar_fragment

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.ppb.navbar_fragment.fragment.ActivityFragment
import com.ppb.navbar_fragment.fragment.HomeFragment
import com.ppb.navbar_fragment.fragment.ProfileFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val homeFragment = HomeFragment()
        val activityFragment = ActivityFragment()
        val profileFragment = ProfileFragment()

        val navbar = findViewById<BottomNavigationView>(R.id.navbar)

        makeCurrentFragment(homeFragment)
        navbar.setOnItemSelectedListener {
            item ->
            when(item.itemId) {
                R.id.home -> makeCurrentFragment(homeFragment)
                R.id.add -> makeCurrentFragment(activityFragment)
                R.id.profile -> makeCurrentFragment(profileFragment)
            }
            true
        }
    }

    private fun makeCurrentFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.frameNavbar, fragment)
            commit()
        }
    }
}
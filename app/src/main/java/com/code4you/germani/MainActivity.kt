package com.code4you.germani
import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)

        // Set default fragment
        loadFragment(ResultsFragment())

        // Handle bottom navigation item clicks
        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            var selectedFragment: Fragment? = null
            when (item.itemId) {
                R.id.nav_results -> selectedFragment = ResultsFragment()
                R.id.nav_stats -> selectedFragment = StatsFragment()
                R.id.nav_matches -> selectedFragment = MatchesFragment()
                R.id.nav_info -> selectedFragment = InfoFragment()
            }
            if (selectedFragment != null) {
                loadFragment(selectedFragment)
            }
            true
        }
    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}
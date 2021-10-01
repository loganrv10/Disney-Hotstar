package com.example.mydisney

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.example.mydisney.Fragment.*
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
    lateinit var dwlayout : DrawerLayout
    lateinit var ivmenu : ImageView
    lateinit var drawernav: NavigationView
    lateinit var toolbar : androidx.appcompat.widget.Toolbar

    var bottomNavigationView: BottomNavigationView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        dwlayout = findViewById(R.id.dwlayout)
        ivmenu = findViewById(R.id.hamburger)
        drawernav = findViewById(R.id.drawernav)
        toolbar = findViewById(R.id.toolbar)

        supportFragmentManager.beginTransaction().replace(R.id.FrameLayout, HomeFragment()).commit()
        bottomNavigationView = findViewById<View>(R.id.notificationbottom) as BottomNavigationView
        bottomNavigationView!!.setOnNavigationItemSelectedListener { item ->
            var temp: Fragment? = null
            when (item.itemId) {
                R.id.home -> temp = HomeFragment()
                R.id.tv -> temp = TvFragment()
                R.id.disney -> temp = DisneyFragment()
                R.id.movies -> temp = MoviesFragment()
                R.id.sports -> temp = SportsFragment()
            }
            assert(temp != null)
            supportFragmentManager.beginTransaction().replace(R.id.FrameLayout, temp!!).commit()
            true
        }



        var togglee: ActionBarDrawerToggle = ActionBarDrawerToggle(this,dwlayout,R.string.nav_open,R.string.nav_close)

        dwlayout.addDrawerListener(togglee)

        togglee.syncState()


        ivmenu.setOnClickListener {

            dwlayout.openDrawer(drawernav)
        }
    }

    override fun onBackPressed() {
        if (dwlayout.isDrawerOpen(GravityCompat.START)) {
            dwlayout.closeDrawer(drawernav)
        } else {

            super.onBackPressed()

        }
    }
}
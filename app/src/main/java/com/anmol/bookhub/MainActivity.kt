 package com.anmol.bookhub

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.BoringLayout
import android.view.Gravity
import android.view.MenuItem
import android.widget.FrameLayout
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import java.util.*

 class MainActivity : AppCompatActivity() {
    lateinit var drawerLayout: DrawerLayout
    lateinit var coordinatorLayout: CoordinatorLayout
    lateinit var toolbar: Toolbar
    lateinit var frameLayout: FrameLayout
    lateinit var navigationView: NavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        drawerLayout = findViewById(R.id.drawerLayout)
        coordinatorLayout = findViewById(R.id.coordinatorLayout)
        toolbar = findViewById(R.id.toolbar)
        frameLayout = findViewById(R.id.frameLayout)
        navigationView = findViewById(R.id.navigationView)
        setUpToolbar()
        val actionBarDrawerToggle = ActionBarDrawerToggle(
            this@MainActivity,
            drawerLayout,
            R.string.open_drawer,
            R.string.close_drawer
        )
        drawerLayout.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()

        navigationView.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.dashboard -> {
                    Toast.makeText(this@MainActivity, "Dashboard", Toast.LENGTH_SHORT).show()
                }
                R.id.favourites -> {
                    Toast.makeText(this@MainActivity, "Favourites", Toast.LENGTH_SHORT).show()
                }
                R.id.profile -> {
                    Toast.makeText(this@MainActivity, "profile", Toast.LENGTH_SHORT).show()
                }
                R.id.aboutApp -> {
                    Toast.makeText(this@MainActivity, "About App", Toast.LENGTH_SHORT).show()
                }
            }
            return@setNavigationItemSelectedListener true
        }

    }
    private fun setUpToolbar(){
        setSupportActionBar(toolbar)
        supportActionBar?.title = "Bookhub"
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

     override fun onOptionsItemSelected(item: MenuItem): Boolean {
         val id = item.itemId
         if(id == android.R.id.home) {
             drawerLayout.openDrawer(GravityCompat.START)
         }
         return super.onOptionsItemSelected(item)
     }

 }
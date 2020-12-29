/*package com.example.bottom_navigation_bar

import com.example.tubeshotel_u.*
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import com.example.bottom_navigation_bar.fragments.HomeFragment
import com.example.tubeshotel_u.statusFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class Menuuhome:AppCompatActivity() {
    private var content: FrameLayout? = null
    private val homeFragment = HomeFragment()
    private val statusFragment = statusFragment()

    ///
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_home)
        replaceFragment(homeFragment)
        ///
        jayakartaHotelHome.setOnClickListener {
            val intent = Intent(this, Hotelmenu1::class.java)
            startActivity(intent)
        }
        jayakartaHoteljkt.setOnClickListener {
            val intentjkt = Intent(this, Hotelmenu2::class.java)
            startActivity(intentjkt)
        }


    }

    private fun replaceFragment(fragment: Fragment){
        if(fragment !=null){
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container,fragment)
            transaction.commit()
        }
    }


}

*/


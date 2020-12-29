package com.example.tubeshotel_u

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.tubeshotel_u.fragments.HomeFragment
import kotlinx.android.synthetic.main.activity_menu_home.*

class Menuhome:AppCompatActivity() {
    private val homeFragment = HomeFragment()
    private val statusFragment = statusFragment()
    private val profileFragment = ProfileFragment()

    ///
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_home)
        replaceFragment(homeFragment)

        bottom_navigation.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.homeMenu -> replaceFragment(homeFragment)
                R.id.statusMenu ->replaceFragment(statusFragment)
                R.id.profileMenu->replaceFragment(profileFragment)
            }
            true
        }

/*
        fjayakartaHotelHome.setOnClickListener {
            val intent = Intent(this, Hotelmenu1::class.java)
            startActivity(intent)
        }
        fjayakartaHoteljkt.setOnClickListener {
            val intentjkt = Intent(this, Hotelmenu2::class.java)
            startActivity(intentjkt)
        }
*/

    }


    private fun replaceFragment(fragment: Fragment){
        if(fragment !=null){
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container,fragment)
            transaction.commit()
        }
    }


}




/*package com.example.tubeshotel_u
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_dashboard_home.*
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import com.example.bottom_navigation_bar.fragments.HomeFragment
import com.example.tubeshotel_u.statusFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class dashboardhome:AppCompatActivity() {
    private var content: FrameLayout? = null

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.homeMenu -> {
                val fragment = HomeFragment.newInstance()
                addFragment(fragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.statusMenu -> {
                val fragment = statusFragment()
                addFragment(fragment)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    private fun addFragment(fragment: Fragment) {
        supportFragmentManager
                .beginTransaction()
                .setCustomAnimations(R.anim.design_bottom_sheet_slide_in, R.anim.design_bottom_sheet_slide_out)
                .replace(R.id.content, fragment, fragment.javaClass.getSimpleName())
                .commit()
    }

    ///
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_home)
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        val fragment = HomeFragment.newInstance()
        addFragment(fragment)

        jayakartaHotelHome.setOnClickListener {
            val intent = Intent(this, Hotelmenu1::class.java)
            startActivity(intent)
        }
        jayakartaHoteljkt.setOnClickListener {
            val intentjkt = Intent(this, Hotelmenu2::class.java)
            startActivity(intentjkt)
        }


    }
}
*/
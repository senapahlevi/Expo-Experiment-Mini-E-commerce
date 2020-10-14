package com.example.tubeshotel_u
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_dashboard_home.*

class dashboardhome:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard_home)
        jayakartaHotelHome.setOnClickListener {
            val intent = Intent(this, Hotelmenu1::class.java)
            startActivity(intent)

        }
        jayakartaHoteljkt.setOnClickListener {
            val intentjkt = Intent(this,Hotelmenu2::class.java)
            startActivity(intentjkt)
        }


    }


}
fun main(){
    println("test")
}

package com.example.tubeshotel_u

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import com.google.firebase.database.*

class ShowStatus : AppCompatActivity() {
    lateinit var ref : DatabaseReference
    lateinit var list :MutableList<Booked>
    lateinit var listView :ListView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_status)

        ref= FirebaseDatabase.getInstance().getReference("Booking")
        list = mutableListOf()
        listView = findViewById(R.id.listView)

      ref.addValueEventListener(object :ValueEventListener{
            override fun onCancelled(p0: DatabaseError) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onDataChange(p0: DataSnapshot) {
                if(p0!!.exists()){
                    //list.clear buat update /delete
                    list.clear()
                    for(h in p0.children){
                        val user = h.getValue(Booked::class.java)
                        list.add(user!!)
                    }
                    val adapter = Adapter(applicationContext,R.layout.users,list)
                    listView.adapter = adapter
                }
            }
        })



    }
}

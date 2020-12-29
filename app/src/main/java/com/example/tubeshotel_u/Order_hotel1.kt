package com.example.tubeshotel_u

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_order_hotel1.*
import org.w3c.dom.Text
import java.text.SimpleDateFormat
import java.util.*

class Order_hotel1 : AppCompatActivity() {

    //ini bagian date
    var formatDate = SimpleDateFormat("dd MMM YYYY",Locale.US)
    lateinit var ref : DatabaseReference



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order_hotel1)
        ref = FirebaseDatabase.getInstance().getReference("Booking")

        btnPickDate.setOnClickListener(View.OnClickListener{
            val getDate = Calendar.getInstance()
            val datepicker = DatePickerDialog(this,android.R.style.Theme_Holo_Light_Dialog_MinWidth,DatePickerDialog.OnDateSetListener { datepicker, i, i2, i3 ->
                val selectDate = Calendar.getInstance()
                selectDate.set(Calendar.YEAR,i)
                selectDate.set(Calendar.MONTH,i2)
                selectDate.set(Calendar.DAY_OF_MONTH,i3)
                val date = formatDate.format(selectDate.time)
                Toast.makeText(this,"Date: " +date,Toast.LENGTH_SHORT).show()
                txtDate.text = date
            }, getDate.get(Calendar.YEAR),getDate.get(Calendar.MONTH),getDate.get(Calendar.DAY_OF_MONTH))
            datepicker.show()
        })

      confirm_booking.setOnClickListener {
        savedata()
          val intent = Intent (this, ShowStatus::class.java)
          startActivity(intent)
      }
    }
        private fun savedata(){
            val jmlorang = jumlahOrang.text.toString()
            val datee = txtDate.text.toString()
            val lamaa = lama.text.toString()


            val userId = ref.push().key.toString()
            val booked = Booked(userId,jmlorang,datee,lamaa)
            ref.child(userId).setValue(booked).addOnCompleteListener{
                Toast.makeText(this,"Sukses", Toast.LENGTH_SHORT).show()
                jumlahOrang.setText("")
                txtDate.setText("")
                lama.setText("")
            }
        }



    //get dat



}
//data simpan firebase

/*
        jumlahorange = findViewById(R.id.jumlahOrang)
        txtDatee = findViewById(R.id.txtDate)
        confirmbooking = findViewById(R.id.confirm_booking)

        confirmbooking.setOnClickListener(this)
        //bagian datepick
        btnPickDate.setOnClickListener(View.OnClickListener{
            val getDate = Calendar.getInstance()
            val datepicker = DatePickerDialog(this,android.R.style.Theme_Holo_Light_Dialog_MinWidth,DatePickerDialog.OnDateSetListener { datepicker, i, i2, i3 ->
                val selectDate = Calendar.getInstance()
                selectDate.set(Calendar.YEAR,i)
                selectDate.set(Calendar.MONTH,i2)
                selectDate.set(Calendar.DAY_OF_MONTH,i3)
                val date = formatDate.format(selectDate.time)
                Toast.makeText(this,"Date: " +date,Toast.LENGTH_SHORT).show()
                txtDate.text = date
            }, getDate.get(Calendar.YEAR),getDate.get(Calendar.MONTH),getDate.get(Calendar.DAY_OF_MONTH))
            datepicker.show()
        })
*/
/*
    override fun onClick(view: View){
        saveData()
    }
    private fun saveData(){
        val jumlahorangg = jumlahOrang.text.toString().trim()
        val txtDatees = txtDate.text

        if(jumlahorangg.isEmpty()){
            jumlahorange.error="kosong "
            return
        }

        val ref = FirebaseDatabase.getInstance().getReference("booked")
        val bookId = ref.push().key
        val boook = Booked(bookId,jumlahorange)
        if(bookId!=null){
            ref.child(bookId).setValue(boook).addOnCompleteListener{
                Toast.makeText(applicationContext, "Sukses tersimpan",Toast.LENGTH_SHORT).show()
            }
        }
*/
package com.example.tubeshotel_u
import android.content.ContentValues
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.btnregis
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivityy:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        var helper  = MyDBHelper(applicationContext)
        var db      = helper.readableDatabase
        var rs      = db.rawQuery("SELECT * FROM USERS",null)
        if(rs.moveToNext())
            Toast.makeText(applicationContext,rs.getString(1),Toast.LENGTH_LONG).show()
        btnregis.setOnClickListener {
            var cv= ContentValues()
            cv.put("UNAME",regisname.text.toString())
            cv.put("EMAIL",regisemail.text.toString())
            cv.put("PHONE",regisphone.text.toString())
            cv.put("PWD",regispswd.text.toString())
            db.insert("USERS",null,cv)
            regisname.setText("")
            regisemail.setText("")
            regisphone.setText("")
            regispswd.setText("")

            regisname.requestFocus()

        }
    }
}
package com.example.tubeshotel_u
import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.klinker.android.link_builder.Link
import com.klinker.android.link_builder.applyLinks
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivityy:AppCompatActivity() {
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        auth = FirebaseAuth.getInstance()
        signIn()

        btnregis.setOnClickListener{
            signUpUser()
            Log.e("action","signup")
            //if(regisemail.text.trim().toString().isNotEmpty() || regispswd.text.trim().toString()
        }
    }
    private fun signIn(){
        val Linksigninn = Link("SignIn")
                .setOnClickListener {
                    Log.e("action","tulisannnn")

                    startActivity(Intent(this,LoginActivityy::class.java))
                    finish()
                }
        Linksignin.applyLinks(Linksigninn)
    }


    private fun signUpUser() {

        if(regisemail.text.toString().isEmpty()){
            regisemail.error = "Please enter email"
            regisemail.requestFocus()
            return
        }

        if(regispswd.text.toString().isEmpty()){
            regispswd.error = "Please enter password"
            regispswd.requestFocus()
            return
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(regisemail.text.toString()).matches()){
            regisemail.error = "please enter valid email"
            regisemail.requestFocus()
            return
        }
        auth.createUserWithEmailAndPassword(regisemail.text.toString(),regispswd.text.toString())
                .addOnCompleteListener(this){ task ->
                    if(task.isSuccessful){
                        Toast.makeText(baseContext,"Sign UP SUKSES MASBRO!!!",Toast.LENGTH_SHORT).show()
                       // startActivity(Intent(this,LoginActivityy::class.java))
                        //finish()
                    }
                    else{
                        Toast.makeText(baseContext,"Sign UP failed please try again",Toast.LENGTH_SHORT).show()
                    }

                }
    }

}






/*

 /* if(regisname.text.toString().isEmpty()){
               regisname.error = "Please enter username"
               regisname.requestFocus()
               return
           }
            if(regisphone.text.toString().isEmpty()){
               regisphone.error = "Please enter phone"
               regisphone.requestFocus()
               return
           }

           */




////////////////////

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

 */
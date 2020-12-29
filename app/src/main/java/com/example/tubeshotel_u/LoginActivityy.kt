package com.example.tubeshotel_u

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DatabaseReference
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_register.*

class LoginActivityy: AppCompatActivity() {
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        auth = FirebaseAuth.getInstance()
        // Initialize Firebase Auth

        btnlogin.setOnClickListener {
            doLogin()
            Log.e("action","signin")

        }
    }

    private fun doLogin() {
        if (Loginemail.text.toString().isEmpty()) {
            Loginemail.error = "Please enter email"
            Loginemail.requestFocus()
            return
        }

        if (Loginpswd.text.toString().isEmpty()) {
            Loginpswd.error = "Please enter password"
            Loginpswd.requestFocus()
            return
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(Loginemail.text.toString()).matches()) {
            Loginemail.error = "please enter valid email"
            Loginemail.requestFocus()
            return
        }

        auth.signInWithEmailAndPassword(Loginemail.text.toString(), Loginpswd.text.toString())
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information
                        val user = auth.currentUser
                        updateUI(user)
                    } else {
                        // If sign in fails, display a message to the user.
                        Toast.makeText(baseContext, "Authentication failed.",
                                Toast.LENGTH_SHORT).show()
                        updateUI(null)
                    }
                }

        /*
        auth.createUserWithEmailAndPassword(regisemail.text.toString(), regispswd.text.toString())
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        val user = auth.currentUser
                        updateUI(user)
                    } else {

                        Toast.makeText(baseContext, "Authentication failed.",
                                Toast.LENGTH_SHORT).show()
                        updateUI(null)
                    }
                }*/
    }
    // cek jika user lagi login alias non null dan perbarui UI sesuai
    // Check if user is signed in (non-null) and update UI accordingly.
    public override fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
        val currentUser = auth.currentUser
        updateUI(currentUser)
    }
   private fun updateUI(currentUser: FirebaseUser?){
        if(currentUser != null) {
            startActivity(Intent(this,SplasshScreenn::class.java))
        }
        else{
            Toast.makeText(
                    baseContext,"Login failed",Toast.LENGTH_SHORT
            ).show()
        }
    }
}
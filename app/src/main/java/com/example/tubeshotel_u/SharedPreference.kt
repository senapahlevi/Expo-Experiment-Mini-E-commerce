package com.example.tubeshotel_u
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import android.content.Context
import android.content.SharedPreferences
import android.provider.Settings.Global.putString
import kotlinx.android.synthetic.main.activity_sharedpreference.*

class SharedPreference:AppCompatActivity() {
    override fun onCreate(savedInstanceState:Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sharedpreference)
        loadData()
        btn_save.setOnClickListener {
            saveData()
        }
    }
    private fun saveData() {
        val insertedText: String = edt_name.text.toString()
        hasilText.text = insertedText
        val sharedPreferences = getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.apply {
            putString("STRING_KEY", insertedText)
            putBoolean("BOOLEAN_KEY", switchBtn.isChecked)
        }.apply()
        Toast.makeText(this, "Data saved", Toast.LENGTH_SHORT).show()
    }
    private fun loadData(){
        val sharedPreferences=getSharedPreferences("sharedPrefs",Context.MODE_PRIVATE)
        val savedString = sharedPreferences.getString("STRING_KEY",null)
        val savedBoolean=sharedPreferences.getBoolean("BOOLEAN_KEY",false)

        hasilText.text = savedString
        switchBtn.isChecked=savedBoolean
    }
}
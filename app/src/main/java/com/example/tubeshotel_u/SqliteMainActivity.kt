/*package com.example.tubeshotel_u

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_sqliteexample.*

class SqliteMainActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sqliteexample)
            val context = this
            var db = DatabaseHandlerSqlite(context)

        btn_insert.setOnClickListener({
            if(editName.text.toString().length>0 && editNumber.text.toString().length>0){
                var user = UserSqlite(editName.text.toString(),editName.text.toString().toInt())
                db.insertData(user)
            }else{
               Toast.makeText(context,"please fill all",Toast.LENGTH_SHORT).show()
            }
        })
        btn_read.setOnClickListener({
            var data = db.readData()
            resultText.text = ""
            for(i in 0.. (data.size-1)){
                resultText.append((data.get(i).id.toString() + " " + data.get(i).age + "\n"))

            }
        })
        btn_update.setOnClickListener({
            db.updateData()
            btn_read.performClick()
        })
        btn_delete.setOnClickListener({
            db.deleteData()
            btn_read.performClick()
        })
    }
}
*/

package com.example.tubeshotel_u

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class MyDBHelper(context:Context):SQLiteOpenHelper(context,"USERDATABASE",null,1) {
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("CREATE TABLE USERS(USERID INTEGER PRIMARY KEY AUTOINCREMENT,UNAME TEXT,EMAIL TEXT,PHONE TEXT,PWD TEXT)")
        db?.execSQL("INSERT INTO USERS(UNAME,EMAIL,PHONE,PWD) VALUES('sena','sena@gmail.com','0896','senapswd')")
        db?.execSQL("INSERT INTO USERS(UNAME,EMAIL,PHONE,PWD) VALUES('bambang','crush@gmail.com','0896','bambangpswd')")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
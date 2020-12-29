package com.example.tubeshotel_u

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.TextView

class Adapter(val mCtx: Context, val layoutResId:Int,val list:List<Booked>)
    : ArrayAdapter<Booked>(mCtx,layoutResId,list){
       override fun getView(position:Int, convertView: View?, parent:ViewGroup):View{
           val layoutInflater: LayoutInflater = LayoutInflater.from(mCtx)
           val view: View = layoutInflater.inflate(layoutResId,null)

           val jumrangAdapt =view.findViewById<EditText>(R.id.jumlahOrang)
           val textShowjmlorang= view.findViewById<TextView>(R.id.textNama)
           val user = list[position]

           textShowjmlorang.text = user.jmlorang

           return view
       }
    }

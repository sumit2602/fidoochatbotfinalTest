package com.example.myapplication.adapter.orderStatusMsgAdapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.adapter.botViewHolder

class orderStatusAdapter(val context: Context, var msgdatalist:List<String>) : RecyclerView.Adapter<botmsgViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): botmsgViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.botitemlayout,parent,false)
        return botmsgViewHolder(view)
    }

    override fun onBindViewHolder(holder: botmsgViewHolder, position: Int) {
        val model=msgdatalist[position]
        holder.setdata(model)
    }

    override fun getItemCount(): Int {
        return  msgdatalist.size
    }

}
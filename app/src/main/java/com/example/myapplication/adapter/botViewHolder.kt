package com.example.myapplication.adapter

import android.content.Intent
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.Models.orderStatus.OrderStatusResponse
import kotlinx.android.synthetic.main.botitemlayout.view.*

class botViewHolder (val view : View) : RecyclerView.ViewHolder(view) {

    fun botclick(orderStatusResponse: OrderStatusResponse, intent: Intent){

      view.cancelButton.text = intent.putExtra("EXTRA_SESSION_ID", 1).toString()

    }
}
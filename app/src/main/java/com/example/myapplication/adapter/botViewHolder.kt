package com.example.myapplication.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.Models.orderStatus.OrderStatusResponse
import kotlinx.android.synthetic.main.botitemlayout.view.*

class botViewHolder (val view : View) : RecyclerView.ViewHolder(view) {

    fun setdata(orderStatusResponse: String) {
        view.apply {
            if (botlogocount.botcount >= 1) {
                tvTitle.text = orderStatusResponse
                botlogo.visibility = View.INVISIBLE
            } else {
                tvTitle.text = orderStatusResponse
            }
        }
        botlogocount.botcount++
    }
}

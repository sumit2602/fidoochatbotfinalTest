package com.example.myapplication.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.Models.orderStatus.OrderStatusResponse

import com.example.myapplication.R

class MainAdapter(val context: Context, var datalist:List<String>) : RecyclerView.Adapter<botViewHolder>() {

    //    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
//        val view: View
//        return if(viewType==0) {
//
//            val view = LayoutInflater.from(context)
//                .inflate(R.layout.botitemlayout, parent, false)
//            return botViewHolder(view)
//        }else
//        {
//            val view = LayoutInflater.from(context)
//                .inflate(R.layout.useritemlayout, parent, false)
//            return userViewHolder(view)
//        }
//    }
//
//    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
//        val viewType: Int = itemlist.get(position).getViewType()
//        when (viewType) {
//            0 -> if (holder is botViewHolder) {
//                val senderModel: botModel = itemlist.get(position) as botModel
//                //(holder as botViewHolder). (senderModel)
//            }
//            1 -> if (holder is userViewHolder) {
//                //val receiverModel: userModel = itemlist.get(position) as userModel
//               // (holder as userViewHolder).setdata(receiverModel)
//            }
//        }
//    }
//
//    override fun getItemCount(): Int {
//      //  TODO("Not yet implemented")
//    }
//
//    override fun getItemViewType(position: Int): Int {
//        return itemlist.get(position).getViewType()
//    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): botViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.botitemlayout,parent,false)
        return botViewHolder(view)
    }

    override fun onBindViewHolder(holder: botViewHolder, position: Int) {
        val model=datalist[position]
        holder.setdata(model)
    }

    override fun getItemCount(): Int {
        return  datalist.size
    }

}
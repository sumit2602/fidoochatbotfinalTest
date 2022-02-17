package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.viewmodel.ChatbotViewModel
import com.example.myapplication.viewmodel.OrderStatusViewModel
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity :AppCompatActivity()
{
    var viewModel: ChatbotViewModel?=null
    var oderStatusViewModel : OrderStatusViewModel? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //orderCancelStatus
        viewModel = ViewModelProvider(this).get(ChatbotViewModel::class.java)
        viewModel?.cancelOrderApi("10","1a9eddfe5e5b2c75f6c15e739e05ab46",100002)
        viewModel?.cancelOrderResponse?.observe(this) {
            Log.d("sddffsddsds", Gson().toJson(it.orderId))
            tv1.text = it.accountId
        }
        //orderStatus
        oderStatusViewModel = ViewModelProvider(this).get(OrderStatusViewModel::class.java)
        oderStatusViewModel?.cancelOrderApi("9","752b1a44c8f596b65b98305627481261",100011)
        oderStatusViewModel?.orderStatusViewModel ?.observe(this) {
            Log.d("sddffsddsds", Gson().toJson(it.orderStatus))
            textView.text = it.orderStatus

        }

    }
}
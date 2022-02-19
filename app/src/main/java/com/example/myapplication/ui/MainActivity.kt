package com.example.myapplication.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.R
import com.example.myapplication.viewmodel.ChatbotViewModel
import com.example.myapplication.viewmodel.OrderStatusViewModel
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*


class MainActivity :AppCompatActivity()
{
    var blink_anim: Animation? = null
    var viewModel: ChatbotViewModel?=null
    var oderStatusViewModel : OrderStatusViewModel? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        CoroutineScope(Dispatchers.Main).launch {
           loadingAnimation1()
        }
        cancel.setOnClickListener{
            l2.visibility = View.VISIBLE
            time1.visibility = View.VISIBLE
            l3.visibility = View.VISIBLE
            l4.visibility = View.VISIBLE
            l5.visibility = View.VISIBLE
            time2.visibility = View.VISIBLE
            l6.visibility = View.VISIBLE

        }

        bt1.setOnClickListener{
            l7.visibility = View.VISIBLE
            time3.visibility = View.VISIBLE
            l8.visibility = View.VISIBLE
            l9.visibility = View.VISIBLE
            time4.visibility = View.VISIBLE
            tvlast.visibility = View.VISIBLE
        }



    //orderCancelStatus
        viewModel = ViewModelProvider(this).get(ChatbotViewModel::class.java)
        viewModel?.cancelOrderApi("10","1a9eddfe5e5b2c75f6c15e739e05ab46",100002)
        viewModel?.cancelOrderResponse?.observe(this) {
            Log.d("sddffsddsds", Gson().toJson(it.orderId))
            tv1.text = it.orderStatus
        }
        //orderStatus
        oderStatusViewModel = ViewModelProvider(this).get(OrderStatusViewModel::class.java)
        oderStatusViewModel?.cancelOrderApi("9","752b1a44c8f596b65b98305627481261",100011)
        oderStatusViewModel?.orderStatusViewModel ?.observe(this) {
            Log.d("sddffsddsds", Gson().toJson(it.orderStatus))
           if(it.orderStatus=="4"){
               CoroutineScope(Dispatchers.Main).launch {
             loadingAnimation()
                   delay(2000)
         }
           }

        }





    }


//    suspend fun main() = coroutineScope {
//        launch {
//            delay(1000)
//            println("Kotlin Coroutines World!")
//        }
//        println("Hello")
//    }

    suspend fun loadingAnimation(){
        blink_anim = AnimationUtils.loadAnimation(getApplicationContext(),
            R.anim.blink);
        textView.startAnimation(blink_anim);
        tv1.startAnimation(blink_anim);
        delay(2000)
        textView.text = "Your order placed at 2020-11-10 00:12:06, usally Fidoo Merchant take 10 min to accept order"

    }

    suspend fun loadingAnimation1(){
        blink_anim = AnimationUtils.loadAnimation(getApplicationContext(),
            R.anim.blink);
        l1.startAnimation(blink_anim);
        delay(2000)



    }



}
package com.example.myapplication.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.animation.Animation
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.R
import com.example.myapplication.viewmodel.ChatbotViewModel
import com.example.myapplication.viewmodel.OrderStatusViewModel
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*
import java.text.SimpleDateFormat
import java.util.*


class MainActivity :AppCompatActivity() {
    var blink_anim: Animation? = null
    var viewModel: ChatbotViewModel? = null
    var oderStatusViewModel: OrderStatusViewModel? = null
    lateinit var dateTime: String
    lateinit var calendar: Calendar
    lateinit var simpleDateFormat: SimpleDateFormat
    lateinit var simpleDateFormat1: SimpleDateFormat


    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        calendar = Calendar.getInstance()
        simpleDateFormat = SimpleDateFormat("EE - dd LLL")
            ////dd.LLL.yyyy HH:mm:ss aaa z
        //EEEE.LLLL.yyyy KK:mm:ss aaa z
        dateTime = simpleDateFormat.format(calendar.time).toString()
        DateandTime.text = dateTime

        simpleDateFormat1 = SimpleDateFormat(" KK:mm")
        dateTime = simpleDateFormat1.format(calendar.time).toString()
        DateandTime2.text = dateTime
        time1.text = dateTime
        time2.text = dateTime
        time3.text = dateTime

        cancel.setOnClickListener {
            l2.visibility = View.VISIBLE
            time1.visibility = View.VISIBLE
            l3.visibility = View.VISIBLE
            l4.visibility = View.VISIBLE
            l5.visibility = View.VISIBLE
            time2.visibility = View.VISIBLE
            l6.visibility = View.VISIBLE
            orderconfirmStatus.text = "Cancel my order"
            //orderCancelStatus
            viewModel = ViewModelProvider(this).get(ChatbotViewModel::class.java)
            viewModel?.cancelOrderApi("10", "1a9eddfe5e5b2c75f6c15e739e05ab46", 100002)
            viewModel?.cancelOrderResponse?.observe(this) {
                Log.d("sddffsddsds", Gson().toJson(it.orderId))
                tv1.text = it.orderStatus
            }

        }

        bt1.setOnClickListener {
            l7.visibility = View.VISIBLE
            time3.visibility = View.VISIBLE
            l8.visibility = View.VISIBLE
            l9.visibility = View.VISIBLE
            time4.visibility = View.VISIBLE
            tvlast.visibility = View.VISIBLE
            userResponse12.text = "No \uD83D\uDC4E"
            finalText2.text = "Thanks for reaching out to us."
            finalText.text = "We apologize for the inconvenience you are experiencing."
        }

        btnthank.setOnClickListener{
            l7.visibility = View.VISIBLE
            time3.visibility = View.VISIBLE
            l8.visibility = View.VISIBLE
            l9.visibility = View.VISIBLE
            time4.visibility = View.VISIBLE
            tvlast.visibility = View.VISIBLE
            userResponse12.text = "Yes, Thank you \uD83D\uDE00"
            finalText2.text = "Thanks for reaching out to us."
            finalText.text = "we are happy to serve you"

        }

        orderstatus.setOnClickListener {
            //orderStatus
            l2.visibility = View.VISIBLE
            time1.visibility = View.VISIBLE
            l3.visibility = View.VISIBLE
            l4.visibility = View.VISIBLE
            l5.visibility = View.VISIBLE
            time2.visibility = View.VISIBLE
            l6.visibility = View.VISIBLE
            orderconfirmStatus.text = "Order Not Confirm Yet"
            oderStatusViewModel = ViewModelProvider(this).get(OrderStatusViewModel::class.java)
            oderStatusViewModel?.cancelOrderApi("9", "752b1a44c8f596b65b98305627481261", 100011)
            oderStatusViewModel?.orderStatusViewModel?.observe(this) {
                Log.d("sddffsddsds", Gson().toJson(it.orderStatus))
                if (it.orderStatus == "4") {
                    CoroutineScope(Dispatchers.Main).launch {
                        //loadingAnimation()
                        delay(2000)
                        tv1.text = "Your order placed at 2020-11-10 00:12:06, usally Fidoo Merchant take 10 min to accept order"
                    }
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

//    suspend fun loadingAnimation(){
//        blink_anim = AnimationUtils.loadAnimation(getApplicationContext(),
//            R.anim.blink);
//        textView.startAnimation(blink_anim);
//        tv1.startAnimation(blink_anim);
//        delay(2000)
//
//
//    }

//
}



package com.example.myapplication.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.Models.chatbotButtonLogic.ButtonLogicModel
import com.example.myapplication.R
import com.example.myapplication.adapter.MainAdapter
import com.example.myapplication.adapter.orderStatusMsgAdapter.orderStatusAdapter
import com.example.myapplication.viewmodel.BotmsgViewModel
import com.example.myapplication.viewmodel.ButtonLogicViewModel
import com.example.myapplication.viewmodel.ChatbotViewModel
import com.example.myapplication.viewmodel.OrderStatusViewModel
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList


class MainActivity :AppCompatActivity() {
    var viewModel: ChatbotViewModel? = null
    var botmsgViewModel : BotmsgViewModel? =null
    var oderStatusViewModel: OrderStatusViewModel? = null
    var buttonLogicViewModel : ButtonLogicViewModel? = null
    lateinit var dateTime: String
    lateinit var calendar: Calendar
    lateinit var simpleDateFormat: SimpleDateFormat
    lateinit var simpleDateFormat1: SimpleDateFormat
    lateinit var mainAdapter: MainAdapter
    lateinit var orderStatusAdapter: orderStatusAdapter


    var newsdata=ArrayList<String>()
    var botMsgdata = ArrayList<String>()
    var btnTextLogic = ArrayList<ButtonLogicModel>()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        oderStatusViewModel = ViewModelProvider(this).get(OrderStatusViewModel::class.java)
        oderStatusViewModel?.cancelOrderApi ("9", "752b1a44c8f596b65b98305627481261", 103550)
        oderStatusViewModel?.orderStatusViewModel?.observe(this) {
            // Log.d("sddffsddsds", Gson().toJson(it))
            newsdata = it as ArrayList<String>
            Log.d("sddffsddskgjgjds", Gson().toJson(it))
            setadapter()
        }





// main button Logic -----------------------------------------------------------------------------------------

        buttonLogicViewModel = ViewModelProvider(this).get(ButtonLogicViewModel::class.java)
        buttonLogicViewModel?.botmsgapiButtonLogic("10", "1a9eddfe5e5b2c75f6c15e739e05ab46", 100002)
        buttonLogicViewModel?.btnLogicViewModel?.observe(this) {
            // Log.d("sddffsddsds", Gson().toJson(it))
            if(it.orderStatus!="1"){
                orderstatus.text = "Where is my order?"
                orderconfirmStatus.text = "Where is my order?"
            }

        }
        ///////////////////////////////////////////////


        orderstatus.setOnClickListener{
            cancel.visibility = View.GONE
            orderstatus.visibility = View.GONE
            l2.visibility = View.VISIBLE
            LayoutFeedback.visibility  =View.VISIBLE
            botmsgViewModel = ViewModelProvider(this).get(BotmsgViewModel::class.java)
            botmsgViewModel?.botmsgapi("9", "752b1a44c8f596b65b98305627481261", 101762)
            botmsgViewModel?.botMsgViewModel?.observe(this) {
                // Log.d("sddffsddsds", Gson().toJson(it))
                botMsgdata =it as ArrayList<String>
                Log.d("sddffsddsds", Gson().toJson(it))
                setRecyclerViewBotmsg()

            }

        }


        cancel.setOnClickListener{
            cancel.visibility = View.GONE
            orderstatus.visibility = View.GONE
            l2.visibility = View.VISIBLE
            viewModel = ViewModelProvider(this).get(ChatbotViewModel::class.java)
            viewModel?.cancelOrderApi("10", "1a9eddfe5e5b2c75f6c15e739e05ab46", 100002)
            viewModel?.cancelOrderResponse?.observe(this) {
                // Log.d("sddffsddsds", Gson().toJson(it.orderId))
                // tv1.text = "Your order has been cancelled"
                // cancelmsgList= it as ArrayList<ChatCancelModel>
                Log.d("sddffsddsds", Gson().toJson(it.orderStatus))
            }
           // if (it.orderstatus)
            botmsgViewModel = ViewModelProvider(this).get(BotmsgViewModel::class.java)
            botmsgViewModel?.botmsgapi("10", "1a9eddfe5e5b2c75f6c15e739e05ab46", 100002)
            botmsgViewModel?.botMsgViewModel?.observe(this) {
                // Log.d("sddffsddsds", Gson().toJson(it))
                botMsgdata =it as ArrayList<String>
                Log.d("sddffsddsds", Gson().toJson(it))

                setRecyclerViewBotmsg()

            }

        }

    }

//    private fun setchetCancelRecyclerview() {
//        Log.d("sddffsddsds", "ef")
//        cancelOrderAdapter = CancelOrderAdapter(this, cancelmsgList )
//        val linearLayoutManager= LinearLayoutManager(this)
//        recyclerView2.adapter= cancelOrderAdapter
//        recyclerView2.layoutManager=linearLayoutManager
//    }

    private fun setadapter() {
        mainAdapter = MainAdapter(this,newsdata)
        val linearLayoutManager= LinearLayoutManager(this)
        recyclerView.adapter= mainAdapter
        recyclerView.layoutManager=linearLayoutManager
    }

    private  fun setRecyclerViewBotmsg(){
        orderStatusAdapter = orderStatusAdapter(this,botMsgdata)
        val linearLayoutManager= LinearLayoutManager(this)
        recyclerView2.adapter= orderStatusAdapter
        recyclerView2.layoutManager=linearLayoutManager

    }

    override fun onResume() {
        super.onResume()

    }
}


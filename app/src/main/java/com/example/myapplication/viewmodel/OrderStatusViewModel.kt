package com.example.myapplication.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.myapplication.Models.orderStatus.OrderStatusResponse
import com.example.myapplication.api_request_retrofit.BackEndApi
import com.example.myapplication.api_request_retrofit.WebServiceClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class OrderStatusViewModel (application: Application) : AndroidViewModel(application) {

    var orderStatusViewModel: MutableLiveData<List<String>>? = null
    var failureResponse: MutableLiveData<String>? = null

    init {
        orderStatusViewModel =  MutableLiveData<List<String>>()
        failureResponse =  MutableLiveData<String>()

    }


    fun cancelOrderApi(accountId: String, accessToken: String, orderId: Int) {

        WebServiceClient.client.create(BackEndApi::class.java).oredrStatusApi(
            accountId = accountId,
            accessToken = accessToken,
            orderId = orderId

        )
            .enqueue(object : Callback<OrderStatusResponse> {

                override fun onResponse(call: Call<OrderStatusResponse>, response: Response<OrderStatusResponse>) {
                    orderStatusViewModel?.value = response.body()?.messages


                }

                override fun onFailure(call: Call<OrderStatusResponse>, t: Throwable) {

                    failureResponse?.value="Something went wrong"
                }
            })
    }

}

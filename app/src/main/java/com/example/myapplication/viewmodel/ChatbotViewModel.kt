package com.example.myapplication.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.myapplication.Models.ChatCancelModel
import com.example.myapplication.Models.cancelStatus.CancelOrderResponse
import com.example.myapplication.api_request_retrofit.BackEndApi
import com.example.myapplication.api_request_retrofit.WebServiceClient


import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ChatbotViewModel (application: Application) : AndroidViewModel(application) {

    var cancelOrderResponse:MutableLiveData<ChatCancelModel>? = null
    var failureResponse:MutableLiveData<String>? = null

    init {
        cancelOrderResponse =  MutableLiveData<ChatCancelModel>()
        failureResponse =  MutableLiveData<String>()

    }


    fun cancelOrderApi(accountId: String, accessToken: String, orderId: Int) {

        WebServiceClient.client.create(BackEndApi::class.java).cancelOrderApi(
            accountId = accountId,
            accessToken = accessToken,
            orderId = orderId

        )
            .enqueue(object : Callback<ChatCancelModel> {

                override fun onResponse(call: Call<ChatCancelModel>, response: Response<ChatCancelModel>) {
                    cancelOrderResponse?.value = response.body()

                }

                override fun onFailure(call: Call<ChatCancelModel>, t: Throwable) {

                    failureResponse?.value="Something went wrong"
                }
            })
    }

}

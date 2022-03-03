package com.example.myapplication.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.myapplication.Models.chatbotButtonLogic.ButtonLogicModel
import com.example.myapplication.api_request_retrofit.BackEndApi
import com.example.myapplication.api_request_retrofit.WebServiceClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ButtonLogicViewModel(application: Application) : AndroidViewModel(application) {

    var btnLogicViewModel: MutableLiveData<ButtonLogicModel>? = null
    var failureResponse: MutableLiveData<String>? = null

    init {
        btnLogicViewModel =  MutableLiveData<ButtonLogicModel>()
        failureResponse =  MutableLiveData<String>()

    }


    fun botmsgapiButtonLogic(accountId: String, accessToken: String, orderId: Int) {

        WebServiceClient.client.create(BackEndApi::class.java).ButtonLogicApi(
            accountId = accountId,
            accessToken = accessToken,
            orderId = orderId

        )
            .enqueue(object : Callback<ButtonLogicModel> {

                override fun onResponse(call: Call<ButtonLogicModel>, response: Response<ButtonLogicModel>) {
                    btnLogicViewModel?.value = response.body()


                }

                override fun onFailure(call: Call<ButtonLogicModel>, t: Throwable) {

                    failureResponse?.value="Something went wrong"
                }
            })
    }

}


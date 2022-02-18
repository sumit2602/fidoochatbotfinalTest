package com.example.myapplication.api_request_retrofit

import com.example.myapplication.Models.cancelStatus.ChatCancelModel
import com.example.myapplication.Models.orderStatus.OrderStatusResponse
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST


interface BackEndApi {

    //chat bot
    @FormUrlEncoded
    @POST("chatbotCancelOrder.inc.php")
    fun cancelOrderApi(
        @Field("accessToken") accessToken: String,
        @Field("accountId") accountId: String,
        @Field("orderId") orderId: Int
    ): Call<ChatCancelModel>

    @FormUrlEncoded
    @POST("chatbotGetOrderStatus.inc.php")
    fun oredrStatusApi(
        @Field("accessToken") accessToken: String,
        @Field("accountId") accountId: String,
        @Field("orderId") orderId: Int
    ): Call<OrderStatusResponse>

}


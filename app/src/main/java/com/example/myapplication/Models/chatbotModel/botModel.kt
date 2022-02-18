package com.example.myapplication.Models.chatbotModel

import com.example.myapplication.adapter.Med

class botModel(var text1 : String, var text2 : String, var text3 : String) : Med() {
    override fun getViewType(): Int {
       return 0

    }
}
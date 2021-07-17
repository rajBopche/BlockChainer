package com.example.blockchainer

import androidx.lifecycle.MutableLiveData

class MainRepo {

    private val socketInstance = SocketBuilder()
    private val transactionLiveData = MutableLiveData<Any>() //todo create model class for transaction data using GSON

    init {
        socketInstance.startSocket()
    }


}
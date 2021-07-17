package com.example.blockchainer

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class MainRepo : SocketListener.SocketObserver {

    private val socketInstance = SocketBuilder()
    private val transactionLiveData = MutableLiveData<TransactionModel>()

    init {
        socketInstance.startSocket(this)
    }

    fun getTransactionLiveData(): LiveData<TransactionModel> = transactionLiveData

    override fun onSocketDataReceived(transactionModel: TransactionModel) {
        transactionLiveData.postValue(transactionModel)
    }
}
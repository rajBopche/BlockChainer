package com.example.blockchainer

import com.google.gson.annotations.SerializedName

data class RootTransaction(
    @SerializedName("x")
    val rootTransaction: TransactionModel
)

data class TransactionModel(

    @SerializedName("hash")
    val transactionHash: String,

    @SerializedName("")
    val transactionAmountList: MutableList<Long>,

    @SerializedName("time")
    val transactionTime: Long

)
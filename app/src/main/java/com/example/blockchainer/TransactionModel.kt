package com.example.blockchainer

import com.google.gson.annotations.SerializedName

data class RootTransaction(
    @SerializedName("x")
    val rootTransaction: TransactionModel
)

data class TransactionModel(

    @SerializedName("hash")
    val transactionHash: String,

    @SerializedName("inputs")
    val inputList: List<Input>,

    @SerializedName("time")
    val transactionTime: Long

)

data class Input(
    @SerializedName("prev_out")
    val previousOut: TransactionValue
)

data class TransactionValue(
    @SerializedName("value")
    val value: Long
)

data class UITransactions(
    val transactionHash: String,
    val transactionAmount: String,
    val transactionTime: String
)
package com.example.blockchainer

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private val repo = MainRepo()

    @RequiresApi(Build.VERSION_CODES.N)
    val transactionMediator: LiveData<UITransactions> =
        Transformations.map(repo.getTransactionLiveData()) {
            parseTransactions(it)
        }

    @RequiresApi(Build.VERSION_CODES.N)
    private fun parseTransactions(it: TransactionModel): UITransactions? {
        val time = DateUtils.toDateStr(it.transactionTime, DateUtils.dd_MM_yyyy_HH_mm_ss)

        var amount = 0.0
        it.inputList.forEach {
            amount += it.previousOut.value
        }
        amount *= SATOSHI_TO_BITCOIN_CONVERSION_FACTOR * BITCOIN_TO_USD_CONVERSION_FACTOR
        val strAmount = String.format("%.2f", amount)
        return if (amount > 100.0) UITransactions(it.transactionHash, strAmount, time)
        else null
    }
}
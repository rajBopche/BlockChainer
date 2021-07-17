package com.example.blockchainer

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private val repo = MainRepo()
    val transactionMediator: LiveData<TransactionModel> =
        Transformations.map(repo.getTransactionLiveData()) {
            it
        }
}
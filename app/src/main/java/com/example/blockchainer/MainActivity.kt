package com.example.blockchainer

import android.os.Build
import android.os.Bundle
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider


class MainActivity : AppCompatActivity() {

    private lateinit var model: MainViewModel
    private lateinit var hashText: TextView
    private lateinit var amount: TextView
    private lateinit var time: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        model = ViewModelProvider(this).get(MainViewModel::class.java)
        hashText = findViewById(R.id.tv_hash_value)
        amount = findViewById(R.id.tv_amount)
        time = findViewById(R.id.tv_time)
    }

    override fun onStart() {
        super.onStart()
        model.transactionMediator.observe(this, Observer(::onTransactionDataReceived))
    }

    @RequiresApi(Build.VERSION_CODES.N)
    private fun onTransactionDataReceived(transactionModel: TransactionModel) {
        hashText.text = transactionModel.transactionHash
        time.text = transactionModel.transactionTime.toString()
    }


}
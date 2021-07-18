package com.example.blockchainer

import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.blockchainer.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
    }

    override fun onStart() {
        super.onStart()
        viewModel.transactionMediator.observe(this, Observer(::onTransactionDataReceived))
    }

    @RequiresApi(Build.VERSION_CODES.N)
    private fun onTransactionDataReceived(transactionModel: TransactionModel) {
        binding.tvHashValue.text = transactionModel.transactionHash
        binding.tvTime.text = transactionModel.transactionTime.toString()
    }


}
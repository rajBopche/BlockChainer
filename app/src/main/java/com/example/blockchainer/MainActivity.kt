package com.example.blockchainer

import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.blockchainer.databinding.ActivityMainBinding
import java.util.*


class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var binding: ActivityMainBinding
    private lateinit var transactionAdapter: TransactionsAdapter
    private val transactionList = ArrayList<TransactionModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewInit()
    }

    private fun viewInit() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        setRecyclerView()
        setListeners()
    }

    private fun setListeners() {
        binding.btnClear.setOnClickListener {
            transactionList.clear()
            transactionAdapter.notifyDataSetChanged()
        }
    }

    private fun setRecyclerView() {
        transactionAdapter = TransactionsAdapter(transactionList)
        binding.rvTransactions.adapter = transactionAdapter
    }

    override fun onStart() {
        super.onStart()
        viewModel.transactionMediator.observe(this, Observer(::onTransactionDataReceived))
    }

    @RequiresApi(Build.VERSION_CODES.N)
    private fun onTransactionDataReceived(transactionModel: TransactionModel) {
        notifyTransactionUpdates(transactionModel)
    }

    private fun notifyTransactionUpdates(transactionModel: TransactionModel) {
        if (transactionList.size >= 5) {
            transactionList.removeAt(transactionList.size - 1)
            transactionList.add(0, transactionModel)
            transactionAdapter.notifyItemRangeChanged(0, transactionList.size)
        } else {
            transactionList.add(transactionModel)
            transactionAdapter.notifyItemChanged(transactionList.size - 1)
        }
        hideLoadingProgress()
    }

    private fun hideLoadingProgress() {
        binding.progressCircular.visibility = View.GONE
    }
}
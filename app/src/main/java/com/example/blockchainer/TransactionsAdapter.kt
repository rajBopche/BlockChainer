package com.example.blockchainer

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.blockchainer.databinding.LayoutTransactionRowItemBinding

class TransactionsAdapter(private val transactionList: List<UITransactions>) :
    RecyclerView.Adapter<TransactionsAdapter.TransactionViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransactionViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = LayoutTransactionRowItemBinding.inflate(layoutInflater, parent, false)
        return TransactionViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TransactionViewHolder, position: Int) {
        holder.bindTransactionData(transactionList[position])
    }

    override fun getItemCount() = transactionList.size

    class TransactionViewHolder(val binding: LayoutTransactionRowItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bindTransactionData(transactionModel: UITransactions) {
            binding.tvHashValue.text = transactionModel.transactionHash
            binding.tvTime.text = transactionModel.transactionTime
            binding.tvAmount.text = transactionModel.transactionAmount
        }
    }
}
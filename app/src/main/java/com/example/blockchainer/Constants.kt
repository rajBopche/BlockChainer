package com.example.blockchainer

const val BASE_URL = "wss://ws.blockchain.info/inv"
const val SUB_UNCONFIRMED_TRANSACTIONS = "{\"op\": \"unconfirmed_sub\"}"
const val UNSUB_UNCONFIRMED_TRANSACTIONS = "{\"op\": \"unconfirmed_unsub\"}"
const val SATOSHI_TO_BITCOIN_CONVERSION_FACTOR = 0.00000001f
const val BITCOIN_TO_USD_CONVERSION_FACTOR = 31729.40f
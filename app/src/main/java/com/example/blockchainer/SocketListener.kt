package com.example.blockchainer

import android.util.Log
import com.google.gson.Gson
import okhttp3.Response
import okhttp3.WebSocket
import okhttp3.WebSocketListener

class SocketListener(val listener: SocketObserver) : WebSocketListener() {

    interface SocketObserver {
        fun onSocketDataReceived(transactionModel: TransactionModel)
    }

    override fun onOpen(webSocket: WebSocket, response: Response) {
        super.onOpen(webSocket, response)
        webSocket.send("{\"op\": \"unconfirmed_sub\"}") //todo refactor with gson stuff
    }

    override fun onMessage(webSocket: WebSocket, text: String) {
        super.onMessage(webSocket, text)
         val data:TransactionModel = Gson().fromJson(text,TransactionModel::class.java)
        listener.onSocketDataReceived(data)
        Log.d("RESPONSE", text) //todo add method to pass back the response to downStream
    }

    override fun onClosing(webSocket: WebSocket, code: Int, reason: String) {
        super.onClosing(webSocket, code, reason)
        webSocket.send("{\"op\": \"unconfirmed_unsub\"}") //todo refactor with json stuff
    }

    override fun onFailure(webSocket: WebSocket, t: Throwable, response: Response?) {
        super.onFailure(webSocket, t, response)
        t.printStackTrace()
        Log.d(
            "ERROR",
            response?.message() ?: "Error"
        ) //todo add method to pass back the error to downStream
    }

}
package com.example.blockchainer

import okhttp3.OkHttpClient
import okhttp3.Request


class SocketBuilder {
    private var okHttpClient: OkHttpClient = OkHttpClient()

    fun startSocket(socketObserver: SocketListener.SocketObserver) {
        val request: Request = Request.Builder().url(BASE_URL).build()
        val listener = SocketListener(socketObserver)
        okHttpClient.newWebSocket(request, listener)
        okHttpClient.dispatcher().executorService().shutdown()
    }

}
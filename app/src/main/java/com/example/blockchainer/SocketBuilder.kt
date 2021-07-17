package com.example.blockchainer

import okhttp3.OkHttpClient
import okhttp3.Request


class SocketBuilder {
    private var okHttpClient: OkHttpClient = OkHttpClient()

    fun startSocket() {
        val request: Request = Request.Builder().url(BASE_URL).build()
        val listener = SocketListener()
        okHttpClient.newWebSocket(request, listener)
        okHttpClient.dispatcher().executorService().shutdown()
    }

}
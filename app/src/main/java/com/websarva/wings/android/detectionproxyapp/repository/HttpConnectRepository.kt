package com.websarva.wings.android.detectionproxyapp.repository

import android.util.Log
import com.websarva.wings.android.detectionproxyapp.model.Result
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import javax.inject.Inject

interface HttpConnectService {
    @GET("/")
    fun getRawResponseForIndex(): Call<Result>
}

interface HttpConnectRepository {
    fun connect(listener: (result: Boolean) -> Unit)
}

class HttpConnectRepositoryClient @Inject constructor(): HttpConnectRepository {
    override fun connect(listener: (result: Boolean) -> Unit) {
        // retrofitの定義
        val retrofit = Retrofit.Builder().apply {
            baseUrl("http://192.168.11.4:8080")
            addConverterFactory(GsonConverterFactory.create())
        }.build()
        // serviceの取得
        retrofit.create(HttpConnectService::class.java).also { service ->
            service.getRawResponseForIndex().also {
                it.enqueue(object: Callback<Result>{
                    override fun onFailure(call: Call<Result>, t: Throwable) {
                        Log.w("Warning", t.message.toString())
                        listener(false)
                    }

                    override fun onResponse(call: Call<Result>, response: Response<Result>) {
                        Log.i("onResponse", "Success!!")
                        listener(true)
                    }
                })
            }
        }
    }
}
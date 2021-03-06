package com.example.buntafujikawa.retrofit_exercise.api

import android.content.Context

import com.example.buntafujikawa.retrofit_exercise.response.Tweet
import com.example.buntafujikawa.retrofit_exercise.services.TwitterService

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

import okhttp3.Interceptor
import okhttp3.OkHttpClient

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

// twitterのapiから取得をする
object TwitterClient {
    private const val BASE_URL = "https://api.twitter.com/1.1/"
    // TODO tokenをどこで管理するかを決める
    private const val AUTH_TOKEN = "*****"

    private fun restClient(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(httpClient)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private val httpClient : OkHttpClient by lazy {
        val builder = OkHttpClient.Builder()
        builder.addInterceptor(appendRequestHeader)
            .connectTimeout(10L, TimeUnit.SECONDS)
            .build()
    }

    private val appendRequestHeader : Interceptor by lazy {
        Interceptor { chain ->
            val request = chain.request().newBuilder()
                .header("Authorization", AUTH_TOKEN)
                .build()
            chain.proceed(request)
        }
    }

    fun fetchAWSTweetList(context: Context, onSuccess: (response: List<Tweet>) -> Unit, onError: Int) {
        val service: TwitterService = restClient().create(TwitterService::class.java)
        service.fetchTweet("awscloud_jp", 10)
            .subscribeOn(Schedulers.io()) // API通信を非同期に実行する
            .observeOn(AndroidSchedulers.mainThread()) // Observableが吐き出したデータを受け取って加工する場所を指定するスレッド
            .subscribe({
                // 成功した時の処理
                onSuccess(it)
            }, {
                // 失敗した時の処理
                onError
            })
    }
}

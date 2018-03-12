package com.example.buntafujikawa.retrofit_exercise.api

import android.content.Context
import com.example.buntafujikawa.retrofit_exercise.response.Repos
import com.example.buntafujikawa.retrofit_exercise.response.User
import com.example.buntafujikawa.retrofit_exercise.services.GitHubRepositoryService
import com.example.buntafujikawa.retrofit_exercise.services.GitHubUserService

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/*
各インターフェースの呼び出しを行う
 */
object APIClient {
    private const val BASE_URL = "https://api.github.com/"
    private const val ACCOUNT_NAME = "buntafujikawa"

    private fun restClient(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun fetchReposList(context:Context,onSuccess: (response: List<Repos>) -> Unit, onError: Int) {
        val service: GitHubRepositoryService = restClient().create(GitHubRepositoryService::class.java)
        service.fetchReposList(ACCOUNT_NAME, "desc")
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

    fun fetchUser(): Response<User> {
        val service = restClient().create(GitHubUserService::class.java)
        return service.fetchUser(ACCOUNT_NAME).execute()
    }
}

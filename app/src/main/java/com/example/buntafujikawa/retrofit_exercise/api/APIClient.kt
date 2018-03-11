package com.example.buntafujikawa.retrofit_exercise.api

import com.example.buntafujikawa.retrofit_exercise.response.Repos
import com.example.buntafujikawa.retrofit_exercise.services.GitHubService
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/*
各インターフェースの呼び出しを行う
 */
object APIClient {
    private const val BASE_URL = "https://api.github.com/"
    private const val ACCOUNT_NAME = "buntafujikawa"

    private fun restClient() : Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun fetchReposList() :Response<List<Repos>> {
        val service = restClient().create(GitHubService::class.java)
        return service.fetchReposList(ACCOUNT_NAME).execute()
    }
}

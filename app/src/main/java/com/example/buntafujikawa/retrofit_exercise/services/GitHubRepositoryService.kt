package com.example.buntafujikawa.retrofit_exercise.services

import com.example.buntafujikawa.retrofit_exercise.response.Repos
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/*
各APIを呼び出すインターフェースは個別のファイルを作成する
 */
// https://developer.github.com/v3/repos/#list-user-repositories
interface GitHubService {
    @GET("users/{user}/repos")
    fun fetchReposList(@Path("user") user: String, @Query("sort") sort: String): Call<List<Repos>>
}

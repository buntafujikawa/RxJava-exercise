package com.example.buntafujikawa.retrofit_exercise.services

import com.example.buntafujikawa.retrofit_exercise.response.User
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

// https://developer.github.com/v3/users/#get-a-single-user
interface GitHubUserService {
    @GET("users/{username}")
    fun fetchUser(@Path("user") user: String) : Call<User>
}

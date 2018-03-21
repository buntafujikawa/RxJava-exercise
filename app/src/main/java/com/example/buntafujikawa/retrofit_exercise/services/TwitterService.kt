package com.example.buntafujikawa.retrofit_exercise.services

import com.example.buntafujikawa.retrofit_exercise.response.Tweet
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

// https://developer.twitter.com/en/docs/tweets/search/api-reference/get-search-tweets.html
interface TwitterService {
    @GET("statuses/user_timeline.json")
    fun fetchTweet(@Query("screen_name") name: String, @Query("count") count: Int) : Observable<List<Tweet>>
}

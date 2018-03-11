package com.example.buntafujikawa.retrofit_exercise.response

/*
各APIからのレスポンスのdataクラスを作成する
 */
data class Repos(val name: String, val description: String, val language: String, val url: String)

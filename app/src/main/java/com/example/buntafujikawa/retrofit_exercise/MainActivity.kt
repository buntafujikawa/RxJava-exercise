package com.example.buntafujikawa.retrofit_exercise

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log

import com.example.buntafujikawa.retrofit_exercise.api.APIClient

import kotlinx.android.synthetic.main.activity_main.*
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val handler = Handler()

        // Androidではメインスレッドでネットワーク通信を行うことができない
        thread {
            try {
                val response = APIClient.fetchReposList()
                val firstRepos = response.body()!![0]

                // 別スレッドからUI操作ができないのでhandlerを使用する
                handler.post(Runnable {
                    name_text.text = firstRepos.name
                    description_text.text = firstRepos.description
                    language_text.text = firstRepos.language
                    url_text.text = firstRepos.url
                })

                Log.d("retrofit", "リポジトリのID" + response.body())
            } catch (e: Exception) {
                Log.w("retrofit", "fetchReposList :" + e)
            }
        }
    }
}

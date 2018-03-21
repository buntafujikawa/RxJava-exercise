package com.example.buntafujikawa.retrofit_exercise

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

import com.example.buntafujikawa.retrofit_exercise.api.APIClient
import com.example.buntafujikawa.retrofit_exercise.api.TwitterClient
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        fetchReposList()
        fetchAWSTweetList()
    }

    private fun fetchReposList() {
        // 成功した時の処理
        APIClient.fetchReposList(this,{
            name_text.text = it[0].name
            description_text.text = it[0].description
            language_text.text = it[0].language
            url_text.text = it[0].url
            Log.d("retrofit", "debug fetchReposList")
        },
            // 失敗した時の処理
            // TODO 何かしらエラー時のメッセージを取得して表示させるようにしたようが良いな
            Log.w("retrofit", "warn fetchReposList")
        )
    }

    private fun fetchAWSTweetList() {
        TwitterClient.fetchAWSTweetList(this,{
            name_text.text = it[0].id_str
            Log.d("retrofit", "============================ " + it[0].id_str)
        },
            // 失敗した時の処理
            Log.w("retrofit", "============================ warn fetchReposList")
        )
    }
}

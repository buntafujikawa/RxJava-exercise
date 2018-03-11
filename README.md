# retrofit-exercise
[retrofit](http://square.github.io/retrofit/)を使って[GitHubのAPI](https://developer.github.com/v3/repos/#list-user-repositories)からデータを取得する


## 構成
```
└── retrofit_exercise
    ├── api
    │   └── APIClient.kt
    ├── response
    │   └── Response.kt
    ├── services
    │   └── GithubService.kt
    │
    └── MainActivity.kt
```

## 使い方

パスを可変にする  
`https://api.github.com/users/buntafujikawa/repos`

```kotlin
@GET("users/{user}/repos")
fun fetchReposList(@Path("user") user: String) : Call<List<Repos>>
```

getパラメータ  
`https://api.github.com/users/buntafujikawa/repos?sort=desc`

```kotlin
@GET("users/{user}/repos")
fun fetchReposList(@Path("user") user: String, @Query("sort") sort: String) : Call<List<Repos>>

```

あとはドキュメントみればわかるので、わかんないことがあればそちらを見るようにする

## メモ
### Logについて

```java
Log.v：VERVOSE（すべてのログ情報）
Log.d：DEBUG(デバッグ情報）
Log.i：INFO(情報）
Log.w：WARN(警告）
Log.e：ERROR（致命的な問題）
```

## スレッドからUIを操作する
[スレッドからUIを操作する](http://seesaawiki.jp/w/moonlight_aska/d/%A5%B9%A5%EC%A5%C3%A5%C9%A4%AB%A4%E9UI%A4%F2%C1%E0%BA%EE%A4%B9%A4%EB)を参考にした

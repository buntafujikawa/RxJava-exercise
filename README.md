# RxJava-exercise
[retrofit-exercise](https://github.com/buntafujikawa/retrofit-exercise)をcloneしてきて、ここに[RxJava](http://reactivex.io/)を組み込んだ

## 構成
```
└── retrofit_exercise
    ├── api
    │   └── APIClient.kt
    ├── response
    │   └── Response.kt
    ├── services
    │   ├── GitHubService.kt
    │   └── GitHubUserService.KT
    │
    └── MainActivity.kt
```

## 参考
### 概要に関しては  
[リアクティブプログラミングとRxJavaの概要](https://codezine.jp/article/detail/9570)  
[リアクティブプログラミングへの理解がイマイチだったのでまとめてみた](http://system.blog.uuum.jp/entry/%E3%83%AA%E3%82%A2%E3%82%AF%E3%83%86%E3%82%A3%E3%83%96%E3%83%97%E3%83%AD%E3%82%B0%E3%83%A9%E3%83%9F%E3%83%B3%E3%82%B0%E3%81%B8%E3%81%AE%E7%90%86%E8%A7%A3%E3%81%8C%E3%82%A4%E3%83%9E%E3%82%A4%E3%83%81%E3%81%A0%E3%81%A3)

### 実装部分
[RxJava+RetrofitでAPI通信周りを実装するうえで最低限の知識を30分で詰め込む](https://qiita.com/FumihikoSHIROYAMA/items/201536d9b45ef21b6bc7)    
[KotlinでRetrofitとRxを使ってAPIクライアントをサクッと実装する](https://qiita.com/koki_cheese/items/016220869089e98f3455)  

## TODO
オペレータの部分はまだ手をつけてないのでこれから

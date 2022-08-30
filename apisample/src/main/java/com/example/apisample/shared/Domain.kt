package com.example.apisample.shared

@JvmInline
value class HexColor(val value: String)

enum class BlogSourceType {
    NaverBlog,
    DaumBlog
}

enum class BlogType {
    Naver,
    Daum
}

enum class UserType {
    Google,
    Kakao
}
package com.example.apisample.data.entity.mapper

import com.example.apisample.data.entity.daum.DaumPost
import com.example.apisample.data.entity.naver.NaverPost
import com.example.apisample.shared.BlogType
import com.example.apisample.shared.blog.Blog

//아이디는 어떻게 해야할지 고민중..
private fun DaumPost.toBlog() = Blog(
    id = (0..10000000).random().toLong(),
    title = title,
    info = contents,
    blogUrl = url,
    thumbnail = thumbnail,
    type = BlogType.Daum
)

fun List<DaumPost>.toBlogList() = map(DaumPost::toBlog)
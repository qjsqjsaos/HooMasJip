package com.example.apisample.data.entity.mapper

import com.example.apisample.data.entity.naver.NaverPost
import com.example.apisample.shared.BlogType
import com.example.apisample.shared.blog.Blog

//아이디는 어떻게 해야할지 고민중..
private fun NaverPost.toBlog() = Blog(
    id = (0..10000000).random().toLong(),
    title = title,
    info = description,
    type = BlogType.Naver
)

fun List<NaverPost>.toBlogList() = map(NaverPost::toBlog)
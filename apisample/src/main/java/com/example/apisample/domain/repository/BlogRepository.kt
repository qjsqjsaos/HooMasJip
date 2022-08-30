package com.example.apisample.domain.repository

import com.example.apisample.shared.blog.Blog

interface BlogRepository {

    suspend fun getNaverBlogList(
        query: String,
        display: Int? = null,
        start: Int? = null,
        sort: String? = null
    ): List<Blog>

    suspend fun getDaumBlogList(
        query: String,
        sort: String? = null,
        page: Int? = null,
        size: Int? = null
    ): List<Blog>
}
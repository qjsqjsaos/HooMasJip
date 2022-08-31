package com.example.apisample.data.repository

import android.util.Log
import com.example.apisample.data.RetrofitClient
import com.example.apisample.data.api.BlogApi
import com.example.apisample.data.entity.mapper.toBlogList
import com.example.apisample.domain.repository.BlogRepository
import com.example.apisample.shared.BlogType
import com.example.apisample.shared.blog.Blog

class BlogRepositoryImpl : BlogRepository {

    override suspend fun getNaverBlogList(
        query: String,
        display: Int?,
        start: Int?,
        sort: String?
    ): List<Blog> {
        try {
            val api = RetrofitClient.getClient(BlogType.Naver)!!.create(BlogApi::class.java)
            val response = api.getNaverBlog(
                query = query,
                display = display,
                start = start,
                sort = sort
            )
            if(response.isSuccessful && response.body() != null) {
                response.body()!!.let { blog ->
                    return blog.items?.toBlogList()!!
                }
            }
        } catch (error: Exception) {
            return emptyList()
        }
        return emptyList()
    }

    override suspend fun getDaumBlogList(
        query: String,
        sort: String?,
        page: Int?,
        size: Int?
    ): List<Blog> {
        try {
            val api = RetrofitClient.getClient(BlogType.Daum)!!.create(BlogApi::class.java)
            val response = api.getDaumBlog(
                query = query,
                sort = sort,
                page = page,
                size = size
            )
            if(response.isSuccessful && response.body() != null) {
                response.body().let { blog ->
                    return blog!!.documents.toBlogList()
                }
            }
        } catch (error: Exception) {
            return emptyList()
        }
        return emptyList()
    }
}
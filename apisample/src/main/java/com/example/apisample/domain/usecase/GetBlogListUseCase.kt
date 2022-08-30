package com.example.apisample.domain.usecase

import com.example.apisample.domain.repository.BlogRepository
import com.example.apisample.shared.blog.Blog

class GetBlogListUseCase(
    private val blogRepository: BlogRepository
) {
    suspend fun getBlogDataList(
        query: String,
        display: Int? = null,
        start: Int? = null,
        sort: String? = null
    ): List<Blog> {
        return blogRepository.run {
            emptyList<Blog>()
                .plus(getNaverBlogList(query))
                .plus(getDaumBlogList(query))
                .shuffled()
        }
    }
}
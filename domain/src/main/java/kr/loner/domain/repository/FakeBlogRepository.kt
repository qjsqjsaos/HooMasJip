package kr.loner.domain.repository

import kr.loner.shared.model.Blog

interface FakeBlogRepository {
    suspend fun getFakeBlogDataList():List<Blog>
}
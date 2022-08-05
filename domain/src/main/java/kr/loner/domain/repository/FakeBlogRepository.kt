package kr.loner.domain.repository

import kr.loner.shared.model.FakeBlog

interface FakeBlogRepository {
    suspend fun getFakeBlogDataList():List<FakeBlog>
}
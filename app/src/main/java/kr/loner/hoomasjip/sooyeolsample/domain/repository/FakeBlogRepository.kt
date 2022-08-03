package kr.loner.hoomasjip.sooyeolsample.domain.repository

import kr.loner.shared.model.FakeBlog

interface FakeBlogRepository {
    suspend fun getFakeBlogDataList():List<FakeBlog>
}
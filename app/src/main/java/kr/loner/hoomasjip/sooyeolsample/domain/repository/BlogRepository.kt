package kr.loner.hoomasjip.sooyeolsample.domain.repository

import kr.loner.shared.model.FakeBlog

interface BlogRepository {
    suspend fun getBlogDataList():List<FakeBlog>
}
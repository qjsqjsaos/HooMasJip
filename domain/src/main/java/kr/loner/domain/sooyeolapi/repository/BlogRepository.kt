package kr.loner.domain.sooyeolapi.repository

import kr.loner.shared.model.sooyeol.blog.Blog

interface BlogRepository {
    suspend fun getBlogDataList(
        query: String,
        display: Int?,
        start: Int?,
        sort: String?
    ): Blog?
}
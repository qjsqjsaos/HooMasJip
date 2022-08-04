package kr.loner.hoomasjip.sooyeolsample.domain.repository

import kr.loner.shared.model.Blog

interface BlogRepository {
    suspend fun getBlogDataList():List<Blog>
}
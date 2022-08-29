package kr.loner.domain.sooyeolapi.usecase

import kr.loner.domain.sooyeolapi.repository.BlogRepository
import kr.loner.shared.model.sooyeol.blog.Blog

class GetBlogListUseCase(
    private val blogRepository: BlogRepository
) {
    suspend fun getBlogDataList(
        query: String,
        display: Int?,
        start: Int?,
        sort: String?
    ): Blog? = blogRepository.getBlogDataList(
        query,
        display,
        start,
        sort
    )
}
package kr.loner.hoomasjip.sooyeolsample.domain.usecase

import kr.loner.hoomasjip.sooyeolsample.domain.repository.BlogRepository
import kr.loner.shared.model.FakeBlog
import javax.inject.Inject

class GetBlogListUseCase @Inject constructor(
    private val blogRepository: BlogRepository
) {
    suspend operator fun invoke(): List<FakeBlog> = blogRepository.getBlogDataList()
}
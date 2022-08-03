package kr.loner.hoomasjip.sooyeolsample.domain.usecase

import kr.loner.hoomasjip.sooyeolsample.domain.repository.FakeBlogRepository
import kr.loner.shared.model.FakeBlog
import javax.inject.Inject

class GetFakeBlogListUseCase @Inject constructor(
    private val fakeBlogRepository: FakeBlogRepository
) {
    suspend operator fun invoke(): List<FakeBlog> = fakeBlogRepository.getFakeBlogDataList()
}
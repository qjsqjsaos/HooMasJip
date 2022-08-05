package kr.loner.domain.usecase

import kr.loner.domain.repository.FakeBlogRepository
import kr.loner.shared.model.FakeBlog

class GetFakeBlogListUseCase (
    private val fakeBlogRepository: FakeBlogRepository
) {
    suspend operator fun invoke(): List<FakeBlog> = fakeBlogRepository.getFakeBlogDataList()
}
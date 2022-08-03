package kr.loner.hoomasjip.sooyeolsample.data.repository

import kr.loner.hoomasjip.sooyeolsample.data.datasource.FakeRemoteDataSource
import kr.loner.hoomasjip.sooyeolsample.domain.repository.FakeBlogRepository
import kr.loner.shared.model.FakeBlog

/**TODO:Hilt 로 Repository 주입 예정 */
class FakeBlogRepositoryImpl : FakeBlogRepository {
    override suspend fun getFakeBlogDataList(): List<FakeBlog> {
        return FakeRemoteDataSource.run {
            emptyList<FakeBlog>().plus(getFakeMockNaverBlog()).plus(getFakeMockDaumBlog())
                .shuffled()
        }
    }
}
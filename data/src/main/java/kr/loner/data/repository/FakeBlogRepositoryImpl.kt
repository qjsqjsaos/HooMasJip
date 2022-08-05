package kr.loner.data.repository

import kr.loner.data.datasource.FakeRemoteDataSource
import kr.loner.domain.repository.FakeBlogRepository
import kr.loner.shared.model.FakeBlog

/**TODO:Hilt 로 Repository 주입 예정 */
object FakeBlogRepositoryImpl : FakeBlogRepository {
    override suspend fun getFakeBlogDataList(): List<FakeBlog> {
        return FakeRemoteDataSource.run {
            emptyList<FakeBlog>().plus(getFakeMockNaverBlog()).plus(getFakeMockDaumBlog())
                .shuffled()
        }
    }
}
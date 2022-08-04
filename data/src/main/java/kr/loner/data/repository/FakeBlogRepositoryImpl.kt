package kr.loner.data.repository

import kr.loner.data.datasource.FakeRemoteDataSource
import kr.loner.domain.repository.FakeBlogRepository
import kr.loner.shared.model.Blog

/**TODO:Hilt 로 Repository 주입 예정 */
object FakeBlogRepositoryImpl : FakeBlogRepository {
    override suspend fun getFakeBlogDataList(): List<Blog> {
        return FakeRemoteDataSource.run {
            emptyList<Blog>().plus(getFakeMockNaverBlog()).plus(getFakeMockDaumBlog())
                .shuffled()
        }
    }
}
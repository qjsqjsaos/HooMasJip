package kr.loner.hoomasjip.sooyeolsample.data.repository

import kr.loner.hoomasjip.sooyeolsample.data.datasource.RemoteDataSource
import kr.loner.hoomasjip.sooyeolsample.domain.repository.BlogRepository
import kr.loner.shared.model.FakeBlog

/**TODO:Hilt 로 Repository 주입 예정 */
class BlogRepositoryImpl : BlogRepository {
    override suspend fun getBlogDataList(): List<FakeBlog> {
        return RemoteDataSource.run {
            emptyList<FakeBlog>().plus(getMockNaverBlog()).plus(getMockDaumBlog())
                .shuffled()
        }
    }
}
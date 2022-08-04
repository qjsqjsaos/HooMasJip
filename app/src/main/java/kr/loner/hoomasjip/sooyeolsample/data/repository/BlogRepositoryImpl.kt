package kr.loner.hoomasjip.sooyeolsample.data.repository

import kr.loner.hoomasjip.sooyeolsample.data.datasource.RemoteDataSource
import kr.loner.hoomasjip.sooyeolsample.domain.repository.BlogRepository
import kr.loner.shared.model.Blog

/**TODO:Hilt 로 Repository 주입 예정 */
class BlogRepositoryImpl : BlogRepository {
    override suspend fun getBlogDataList(): List<Blog> {
        return RemoteDataSource.run {
            emptyList<Blog>().plus(getMockNaverBlog()).plus(getMockDaumBlog())
                .shuffled()
        }
    }
}
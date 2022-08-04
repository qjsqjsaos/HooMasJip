package kr.loner.hoomasjip.sooyeolsample.data.datasource

import kr.loner.hoomasjip.sooyeolsample.data.api.Api
import kr.loner.shared.model.Blog
/**TODO:Hilt 로 api 주입 예정 */
object RemoteDataSource {
    suspend fun getMockNaverBlog(): List<Blog> = Api.getMockNaverBlog()
    suspend fun getMockDaumBlog(): List<Blog> = Api.getMockDaumBlog()
}
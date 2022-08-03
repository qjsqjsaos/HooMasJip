package kr.loner.hoomasjip.sooyeolsample.data.datasource

import kr.loner.hoomasjip.sooyeolsample.data.api.FakeApi
import kr.loner.shared.model.FakeBlog
/**TODO:Hilt 로 api 주입 예정 */
object FakeRemoteDataSource {
    suspend fun getFakeMockNaverBlog(): List<FakeBlog> = FakeApi.getFakeMockNaverBlog()
    suspend fun getFakeMockDaumBlog(): List<FakeBlog> = FakeApi.getFakeMockDaumBlog()
}
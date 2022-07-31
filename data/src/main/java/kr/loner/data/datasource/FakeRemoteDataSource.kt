package kr.loner.data.datasource

import kr.loner.data.api.FakeApi
import kr.loner.data.model.FakeDaumBlog
import kr.loner.data.model.FakeNaverBlog
import kr.loner.shared.model.FakeBlog
/**TODO:Hilt 로 api 주입 예정 */
object FakeRemoteDataSource {
    suspend fun getFakeMockNaverBlog(): List<FakeBlog> = FakeApi.getFakeMockNaverBlog()
    suspend fun getFakeMockDaumBlog(): List<FakeBlog> = FakeApi.getFakeMockDaumBlog()
}
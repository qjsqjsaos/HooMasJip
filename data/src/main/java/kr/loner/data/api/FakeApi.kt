package kr.loner.data.api

import android.util.Log
import kotlinx.coroutines.delay
import kr.loner.data.model.FakeDaumBlog
import kr.loner.data.model.FakeNaverBlog
import kr.loner.data.model.mapper.toFakeBlogList
import kr.loner.shared.model.FakeBlog

object FakeApi {
    suspend fun getFakeMockNaverBlog(): List<FakeBlog> {
        delay(300)
        val sampleApiData = mutableListOf<FakeNaverBlog>().apply {
            repeat(10) { i ->
                add(
                    FakeNaverBlog(
                        title = "${i}번째 블로그 타이틀",
                        content = "${i}번째 블로그 설명 설명......."
                    )
                )
            }
        }
        Log.d("checkk1111",sampleApiData.size.toString())
        return sampleApiData.toFakeBlogList()
    }


    suspend fun getFakeMockDaumBlog(): List<FakeBlog> {
        delay(300)
        val sampleApiData = mutableListOf<FakeDaumBlog>().apply {
            repeat(10) { i ->
                add(
                    FakeDaumBlog(
                        title = "${i}번째 블로그 타이틀",
                        contents = "${i}번째 블로그 설명 설명......."
                    )
                )
            }
        }.toList()
        Log.d("checkk2222",sampleApiData.size.toString())
        return sampleApiData.toFakeBlogList()
    }

}
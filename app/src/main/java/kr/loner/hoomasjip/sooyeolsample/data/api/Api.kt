package kr.loner.hoomasjip.sooyeolsample.data.api

import android.util.Log
import kotlinx.coroutines.delay
import kr.loner.hoomasjip.sooyeolsample.data.model.DaumBlog
import kr.loner.hoomasjip.sooyeolsample.data.model.NaverBlog
import kr.loner.hoomasjip.sooyeolsample.data.model.mapper.toBlogList
import kr.loner.shared.model.FakeBlog

object Api {
    suspend fun getMockNaverBlog(): List<FakeBlog> {
        delay(1500)
        val sampleApiData = mutableListOf<NaverBlog>().apply {
            repeat(10) { i ->
                add(
                    NaverBlog(
                        title = "${i}번째 블로그 타이틀",
                        content = "${i}번째 블로그 설명 설명......."
                    )
                )
            }
        }
        Log.d("checkk1111",sampleApiData.size.toString())
        return sampleApiData.toBlogList()
    }


    suspend fun getMockDaumBlog(): List<FakeBlog> {
        delay(1500)
        val sampleApiData = mutableListOf<DaumBlog>().apply {
            repeat(10) { i ->
                add(
                    DaumBlog(
                        title = "${i}번째 블로그 타이틀",
                        contents = "${i}번째 블로그 설명 설명......."
                    )
                )
            }
        }.toList()
        Log.d("checkk2222",sampleApiData.size.toString())
        return sampleApiData.toBlogList()
    }

}
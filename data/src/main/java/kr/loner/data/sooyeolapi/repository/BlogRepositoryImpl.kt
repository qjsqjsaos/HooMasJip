package kr.loner.data.sooyeolapi.repository

import android.util.Log
import kr.loner.data.sooyeolapi.RetrofitClient
import kr.loner.data.sooyeolapi.api.BlogApi
import kr.loner.data.sooyeolapi.entity.NaverBlog
import kr.loner.domain.sooyeolapi.repository.BlogRepository
import kr.loner.shared.BlogType
import kr.loner.shared.model.sooyeol.blog.Blog
import okhttp3.Response
import retrofit2.Call
import retrofit2.Callback
import retrofit2.HttpException

class BlogRepositoryImpl : BlogRepository {

    override suspend fun getBlogDataList(
        query: String,
        display: Int?,
        start: Int?,
        sort: String?
    ): Blog? {
        val api = RetrofitClient.getClient(BlogType.Naver)!!.create(BlogApi::class.java)
        val response = api.getNaverBlog(
                query = query,
                display = display,
                start = start,
                sort = sort
            )
        // TODO: 여기서 막힘. 데이터 왜 못불러 오는지 네이버 홈페이지 예제 확인할 것 
        response.enqueue(object : Callback<NaverBlog?> {
            override fun onResponse(
                call: Call<NaverBlog?>,
                response: retrofit2.Response<NaverBlog?>
            ) {
                Log.d("리스폰스", response.body()?.bloggername.toString())
            }

            override fun onFailure(call: Call<NaverBlog?>, t: Throwable) {
                
            }
        })
//        try {
//            val api = RetrofitClient.getClient(BlogType.Naver)!!.create(BlogApi::class.java)
//            val response = api.getNaverBlog(
//                query = query,
//                display = display,
//                start = start,
//                sort = sort
//            )
//
//            Log.d("리스폰스", response.message())
//
//            if(response.isSuccessful && response.body() != null) {
//                response.body()!!.let {
//                    return Blog(
//                        id = (0..10000000).random().toLong(),
//                        title = it.title,
//                        info = it.description,
//                        img = it.link,
//                        blogUrl = it.bloggerlink,
//                        type = BlogType.Naver
//                    )
//                }
//            }
//        } catch (error: Exception) {
//            Log.d("에러", error.toString())
//            //에외 처리하기
//        }
    }
}
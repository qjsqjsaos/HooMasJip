package kr.loner.data.sooyeolapi.api

import kr.loner.data.sooyeolapi.entity.NaverBlog
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/*
* Naver api 입니다.
* query : 검색을 원하는 문자열이다.
* display : 검색 결과 출력 건수 지정 -> 10(기본값), 100(최대값)
* start : 검색 시작 위치로 최대 1000까지 가능 -> 1(기본값), 1000(최대값)
* sort : 정렬 옵션 : sim(유사도순, 기본값), date(날짜순)
* */
interface BlogApi {

    /*
    * 네이버 블로그의 정보를 가져옵니다.
    * */
    @GET("/v1/search/blog.json")
    suspend fun getNaverBlog(
        @Query("query") query: String?,
        @Query("display") display: Int? = null,
        @Query("start") start: Int? = null,
        @Query("sort") sort: String? = null,
    ): Call<NaverBlog>

}
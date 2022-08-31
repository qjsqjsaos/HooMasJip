package com.example.apisample.data.api

import com.example.apisample.data.entity.daum.DaumBlog
import com.example.apisample.data.entity.naver.NaverBlog
import com.example.apisample.presentation.widget.utils.ApiKey.KAKAO_API_KEY
import com.example.apisample.presentation.widget.utils.ApiKey.NAVER_CLIENT_ID
import com.example.apisample.presentation.widget.utils.ApiKey.NAVER_CLIENT_SECRET
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

/*
* blog api 입니다.
* */
interface BlogApi {
    /*
    * 네이버 블로그의 정보를 가져옵니다.
    * X-Naver-Client-Id : 클라이언트 아이디입니다(필수값)
    * X-Naver-Client-Secret : 시크릿 키입니다(필수값)
    * query : 검색을 원하는 문자열이다.
    * display : 검색 결과 출력 건수 지정 -> 10(기본값), 100(최대값)
    * start : 검색 시작 위치로 최대 1000까지 가능 -> 1(기본값), 1000(최대값)
    * sort : 정렬 옵션 : sim(유사도순, 기본값), date(날짜순)
    * */
    @GET("/v1/search/blog.json")
    suspend fun getNaverBlog(
        @Header("X-Naver-Client-Id") clientId: String = NAVER_CLIENT_ID,
        @Header("X-Naver-Client-Secret") clientSecret: String = NAVER_CLIENT_SECRET,
        @Query("query") query: String,
        @Query("display") display: Int?,
        @Query("start") start: Int?,
        @Query("sort") sort: String?,
    ): Response<NaverBlog>

    /*
    * 다음 블로그의 정보를 가져옵니다.
    * Authorization : 앱 API키입니다.
    * query : 원하는 검색 문자열입니다.
    * sort : 결과 문서 정렬 방식입니다. "accuracy"(정확도순) -> 기본값, "recency"(최신순)
    * page : 결과 페이지 번호 1 ~ 50 사이, 기본값 1
    * size : 한 페이지에 보여질 문자수 1 ~ 50 사이의 값, 기본 값 10
    * */
    @GET("/v2/search/blog")
    suspend fun getDaumBlog(
        @Header("Authorization") authorization: String = KAKAO_API_KEY,
        @Query("query") query : String,
        @Query("sort") sort : String?,
        @Query("page") page: Int?,
        @Query("size") size: Int?
    ): Response<DaumBlog>
}
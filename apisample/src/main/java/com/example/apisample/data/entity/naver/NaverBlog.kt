package com.example.apisample.data.entity.naver

import kotlinx.serialization.Serializable

/*
* NaverBlog 리스폰스 객체입니다.
* display : 검색된 검색 결과의 개수이다.
* items : 개별 검색 결과이며 (하나의 블로그 포스팅) title, link, description, bloggername, bloggerlink을 포함한다.
* lastBuildDate : 검색 결과를 생성한 시간이다.
* start : 검색 결과 문서 중, 문서의 시작점을 의미한다.
* total : 검색 결과 문서의 총 개수를 의미한다.
* */
@Serializable
data class NaverBlog (
    val display: Int? = null,
    val items: List<NaverPost>? = null,
    val lastBuildDate: String? = null,
    val start: Int? = null,
    val total: Int? = null
)
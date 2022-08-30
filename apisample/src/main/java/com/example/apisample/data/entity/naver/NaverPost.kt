package com.example.apisample.data.entity.naver

import kotlinx.serialization.Serializable

/*
* 하나의 네이버 블로그 포스팅 객체입니다.
* bloggerlink : 검색 결과 블로그 포스트를 작성한 블로거의 하이퍼텍스트 link이다.
* bloggername : 검색 결과 블로그 포스트를 작성한 블로거의 이름이다.
* description : 검색 결과 문서의 내용을 요약한 패시지 정보이다. 문서 전체의 내용은 link를 따라가면 읽을 수 있다. 패시지에서 검색어와 일치하는 부분은 태그로 감싸져 있다.
* link : 검색 결과 문서의 하이퍼텍스트 link를 나타낸다.
* postdate : 블로그 포스트를 작성한 날짜이다.
* title : 검색 결과 문서의 제목을 나타낸다. 제목에서 검색어와 일치하는 부분은 태그로 감싸져 있다.
* */
@Serializable
data class NaverPost(
    val bloggerlink: String? = null,
    val bloggername: String? = null,
    val description: String? = null,
    val link: String? = null,
    val postdate: String? = null,
    val title: String? = null
)
package com.example.apisample.data.entity.daum

import kotlinx.serialization.Serializable

/*
* 하나의 다음 블로그 포스팅 데이터이다.
* blogname : 블로그의 이름
* contents : 블로그 글 요약
* datetime : 블로그 글 작성 시간 [YYYY]-[MM]-[DD]T[hh]:[mm]:[ss].000+[tz]
* thumbnail : 미리보기 이미지 url, 미리보기 크기 및 화질은 변경될 수 있음
* title : 블로그 글 제목
* url : 블로그 글 url
* */
@Serializable
data class DaumPost(
    val blogname: String,
    val contents: String,
    val datetime: String,
    val thumbnail: String,
    val title: String,
    val url: String
)
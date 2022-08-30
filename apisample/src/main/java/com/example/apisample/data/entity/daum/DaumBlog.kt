package com.example.apisample.data.entity.daum

import kotlinx.serialization.Serializable

/*
* DaumBlog 리스폰스 객체입니다
* documents : 개별적인 블로그 포스팅 데이터 리스트입니다. title, contents, url, blogname, thumbnail, datetime을 포함합니다.
* meta : 검색된 문서수, 전체 문서 중 노출 가능 문서수를 알 수 있고, 현재 페이지가 마지막 페이지인지 여부가 불리언 값으로 넘겨져 와서,
* 다음 페이지를 요청 가능하게 하는 메타데이터 객체
* */
@Serializable
data class DaumBlog(
    val documents: List<DaumPost>,
    val meta: DaumMeta
)
package com.example.apisample.data.entity.daum

import kotlinx.serialization.Serializable

/*
* 메타데이터입니다.
* is_end : 현재 페이지가 마지막 페이지인지 여부,
* pageable_count : total_count 중 노출 가능 문서 수
* total_count : 검색된 문서 수
* */
@Serializable
data class DaumMeta(
    val is_end: Boolean,
    val pageable_count: Int,
    val total_count: Int
)
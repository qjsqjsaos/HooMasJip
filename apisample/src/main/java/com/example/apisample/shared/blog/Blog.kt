package com.example.apisample.shared.blog

import com.example.apisample.shared.BlogType


/*
* 블로그 데이터 클래스입니다.
* id : 고유값
* title : 블로그의 타이틀명입니다.
* info : 블로그에 대한 설명글 입니다.
* blogUrl : 아이템을 눌렀을 때, 웹뷰로 전달할 url입니다.
* type : blog의 종류를 결정하는 타입 값입니다. (enum)
* */
data class Blog(
    val id: Long,
    val title: String?,
    val info: String? = "",
    val blogUrl: String? = null,
    val thumbnail: String? = null,
    val type: BlogType
)


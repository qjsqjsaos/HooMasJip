package com.example.apisample.shared.user

import com.example.apisample.shared.UserType
import com.example.apisample.shared.blog.Blog
import kr.loner.shared.model.sooyeol.place.GoodPlace

/*
* 유저 추상 클래스입니다.
* id: 고유값,
* name: 사용자 이름 (기획에서는 이름의 필요성이 언급되진 않았지만, 혹시 몰라 넣어보았습니다!)
* myGoodPlaces : 사용자가 등록해 놓은 맛집의 리스트입니다.
* wishList : 사용자의 블로그 목록입니다.
* type : 카카오와 구글 로그인의 구분을 짓는 타입입니다.
* */

data class User(
    val id: Long,
    val name: String,
    val myGoodPlaces: List<GoodPlace>,
    val wishList: List<Blog>,
    val type: UserType
)


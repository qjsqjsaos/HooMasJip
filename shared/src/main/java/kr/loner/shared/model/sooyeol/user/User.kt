package kr.loner.shared.model.sooyeol.user

import kr.loner.shared.model.sooyeol.blog.Blog
import kr.loner.shared.model.sooyeol.place.GoodPlace

/*
* 유저 추상 클래스입니다.
* id: 고유값,
* name: 사용자 이름 (기획에서는 이름의 필요성이 언급되진 않았지만, 혹시 몰라 넣어보았습니다!)
* myGoodPlaces : 사용자가 등록해 놓은 맛집의 리스트입니다.
* */
abstract class User {
    abstract val id: Long
    abstract val name: String
    abstract val myGoodPlaces: List<GoodPlace>
    abstract val wishList: List<Blog>
}


package kr.loner.shared.model.sooyeol.user

import kr.loner.shared.model.sooyeol.blog.Blog
import kr.loner.shared.model.sooyeol.place.GoodPlace

/*
* 카카오 유저 모델입니다.
* id: 고유값,
* name: 사용자 이름 (기획에서는 이름의 필요성이 언급되진 않았지만, 혹시 몰라 넣어보았습니다!)
* myGoodPlaces : 사용자가 등록해 놓은 맛집의 리스트입니다.
* wishList : 사용자의 찜한 목록입니다.
* */
data class KakaoUser(
    override val id: Long,
    override val name: String,
    override val myGoodPlaces: List<GoodPlace>,
    override val wishList: List<Blog>
) : User

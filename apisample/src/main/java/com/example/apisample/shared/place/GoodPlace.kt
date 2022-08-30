package kr.loner.shared.model.sooyeol.place

/*
* 사용자의 맛집 모델입니다.
* id, name, info : GoodPlaceData interface에 설명이 표기되어 있습니다.
* name : 맛집의 이름입니다.
* info : 맛집에 대한 설명글 입니다.
* imgs : 등록해놓은 맛집의 이미지 리스트입니다.
* starPoint : 맛집의 평가 별점입니다. ex) 1 -> 1점, 5 -> 5점
* date : 맛집을 등록한 날짜입니다.
* phoneNum : 맛집의 전화번호입니다.
* address : 맛집의 주소입니다.
* */
data class GoodPlace(
    override val id: Long,
    override val latitude: String?,
    override val longitude: String?,
    val name: String?,
    val info: String?,
    val imgs: List<String?>,
    val rating: Double?,
    val date: String?,
    val phoneNum: String?,
    val address: String?
) : Place

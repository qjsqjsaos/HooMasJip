package kr.loner.shared.model.sooyeol

/*
* 맛집 후기 탭에 아이템 모델입니다.
* id, name, info : GoodPlaceData interface에 설명이 표기되어 있습니다.
* img : view의 표시될 하나의 이미지입니다.
* blogUrl : 아이템을 눌렀을 때, 웹뷰로 전달할 url입니다.
* */
data class Blog(
    override val id: Long,
    override val name: String?,
    override val info: String?,
    val img: String?,
    val blogUrl: String?
) : GoodPlaceData

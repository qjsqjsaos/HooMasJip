package kr.loner.shared.model.sooyeol

/*
* 맛집의 기본 데이터 값 구현입니다.
* id : 고유값
* name : 맛집의 가게명입니다.
* info : 맛집에 대한 설명글 입니다.
* */
interface GoodPlaceData {
    val id: Long
    val name: String?
    val info: String?
}
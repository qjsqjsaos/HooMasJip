package kr.loner.shared.model.sooyeol.place

/*
* 장소 기본 데이터 추상 클래스입니다.
* id : 고유값
* latitude : 장소의 위도입니다.
* longitude : 장소의 경도입니다.
* */
abstract class Place {
    abstract val id: Long
    abstract val latitude: String?
    abstract val longitude: String?
}
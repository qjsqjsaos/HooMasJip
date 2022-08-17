package kr.loner.shared.model.sooyeol.place

/*
* 장소 기본 데이터 인터페이스입니다.
* id : 고유값
* latitude : 장소의 위도입니다.
* longitude : 장소의 경도입니다.
* */
interface Place {
    val id: Long
    val latitude: String?
    val longitude: String?
}
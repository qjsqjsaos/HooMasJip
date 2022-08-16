package kr.loner.shared.model.sooyeol.blog

/*
* 블로그의 기본 데이터 값 추상 클래스입니다.
* id : 고유값
* title : 블로그의 타이틀명입니다.
* info : 블로그에 대한 설명글 입니다.
* img : view의 표시될 하나의 이미지입니다.
* blogUrl : 아이템을 눌렀을 때, 웹뷰로 전달할 url입니다.
* */
abstract class Blog {
    abstract val id: Long
    abstract val title: String?
    abstract val info: String?
    abstract val img: String?
    abstract val blogUrl: String?
}
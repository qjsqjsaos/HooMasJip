package kr.loner.shared.model.sooyeol.blog

/*
* 맛집 후기 탭에 다음 블로그 모델입니다.
* id, title, info, img, blogUrl : GoodPlaceData interface에 설명이 표기되어 있습니다.
* */
data class DaumBlog(
    override val id: Long,
    override val title: String?,
    override val info: String?,
    override val img: String?,
    override val blogUrl: String?
) : Blog()

package kr.loner.shared.model


import kr.loner.shared.BlogSourceType
import kr.loner.shared.HexColor


data class MockBlogData(
    val id: Long,
    val desc: String = "${id}번 묵데이터 입니다.",
    val color: HexColor,
    override val blogTypeBlog: BlogSourceType,
) : BlogData

package kr.loner.shared.model

import kr.loner.shared.BlogSourceType
import kr.loner.shared.HexColor
import kr.loner.shared.exts.toColor

data class FakeBlog(
    val id: Long,
    val title:String,
    val desc: String = "${id}번 묵데이터 입니다.",
    override val blogTypeBlog: BlogSourceType,
    val color: HexColor = blogTypeBlog.toColor(),
) : BlogData

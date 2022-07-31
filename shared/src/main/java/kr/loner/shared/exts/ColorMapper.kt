package kr.loner.shared.exts

import kr.loner.shared.HexColor
import kr.loner.shared.BlogSourceType

fun BlogSourceType.toColor(): HexColor {
    val color = if (this == BlogSourceType.DaumBlog) {
        "#54c1f0"
    } else {
        "#03fc30"
    }
    return HexColor(color)
}
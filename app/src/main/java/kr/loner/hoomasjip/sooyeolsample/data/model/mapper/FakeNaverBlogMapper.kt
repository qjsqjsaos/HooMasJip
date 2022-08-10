package kr.loner.hoomasjip.sooyeolsample.data.model.mapper

import kr.loner.hoomasjip.sooyeolsample.data.model.NaverBlog
import kr.loner.shared.BlogSourceType
import kr.loner.shared.model.FakeBlog

private fun NaverBlog.toBlog() = FakeBlog(
    id = (0..10000000).random().toLong(),
    title = title,
    desc = this.content,
    blogTypeBlog = BlogSourceType.NaverBlog
)

fun List<NaverBlog>.toBlogList() = map(NaverBlog::toBlog)
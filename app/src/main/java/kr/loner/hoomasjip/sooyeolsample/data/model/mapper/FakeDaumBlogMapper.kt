package kr.loner.hoomasjip.sooyeolsample.data.model.mapper

import kr.loner.hoomasjip.sooyeolsample.data.model.DaumBlog
import kr.loner.shared.BlogSourceType
import kr.loner.shared.model.FakeBlog

private fun DaumBlog.toBlog() = FakeBlog(
    id = (0..10000000).random().toLong(),
    title = title,
    desc = this.contents,
    blogTypeBlog = BlogSourceType.DaumBlog
)

fun List<DaumBlog>.toBlogList():List<FakeBlog> = map(DaumBlog::toBlog)
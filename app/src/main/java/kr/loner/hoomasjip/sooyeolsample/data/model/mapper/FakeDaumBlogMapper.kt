package kr.loner.hoomasjip.sooyeolsample.data.model.mapper

import kr.loner.hoomasjip.sooyeolsample.data.model.FakeDaumBlog
import kr.loner.shared.BlogSourceType
import kr.loner.shared.model.FakeBlog

private fun FakeDaumBlog.toFakeBlog() = FakeBlog(
    id = (0..10000000).random().toLong(),
    title = title,
    desc = this.contents,
    blogTypeBlog = BlogSourceType.DaumBlog
)

fun List<FakeDaumBlog>.toFakeBlogList():List<FakeBlog> = map(FakeDaumBlog::toFakeBlog)
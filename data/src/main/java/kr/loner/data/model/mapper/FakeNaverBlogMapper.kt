package kr.loner.data.model.mapper

import kr.loner.data.model.FakeNaverBlog
import kr.loner.shared.BlogSourceType
import kr.loner.shared.model.Blog

private fun FakeNaverBlog.toFakeBlog() = Blog(
    id = (0..10000000).random().toLong(),
    title = title,
    desc = this.content,
    blogTypeBlog = BlogSourceType.NaverBlog
)

fun List<FakeNaverBlog>.toFakeBlogList() = map(FakeNaverBlog::toFakeBlog)
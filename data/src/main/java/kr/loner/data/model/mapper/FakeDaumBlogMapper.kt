package kr.loner.data.model.mapper

import kr.loner.data.model.FakeDaumBlog
import kr.loner.shared.BlogSourceType
import kr.loner.shared.model.Blog

private fun FakeDaumBlog.toFakeBlog() = Blog(
    id = (0..10000000).random().toLong(),
    title = title,
    desc = this.contents,
    blogTypeBlog = BlogSourceType.DaumBlog
)

fun List<FakeDaumBlog>.toFakeBlogList():List<Blog> = map(FakeDaumBlog::toFakeBlog)
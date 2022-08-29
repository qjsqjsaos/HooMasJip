package kr.loner.data.sooyeolapi.entity.mapper

import kr.loner.data.sooyeolapi.entity.NaverBlog

import kr.loner.shared.BlogType
import kr.loner.shared.model.sooyeol.blog.Blog

//아이디는 어떻게 해야할지 고민중..
private fun NaverBlog.toBlog() = Blog(
    id = (0..10000000).random().toLong(),
    title = title,
    blogUrl = bloggerlink,
    type = BlogType.Naver
)

fun List<NaverBlog>.toBlogList() = map(NaverBlog::toBlog)
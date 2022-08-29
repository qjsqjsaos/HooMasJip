package kr.loner.data.sooyeolapi.entity

import kotlinx.serialization.Serializable

@Serializable
data class NaverPost(
    val bloggerlink: String,
    val bloggername: String,
    val description: String,
    val link: String,
    val postdate: String,
    val title: String
)
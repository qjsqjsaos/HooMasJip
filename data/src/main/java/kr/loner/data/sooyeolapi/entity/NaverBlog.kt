package kr.loner.data.sooyeolapi.entity

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonNames
import kr.loner.data.sooyeolapi.DateAsLongSerializer
import java.util.*

@Serializable
data class NaverBlog @OptIn(ExperimentalSerializationApi::class) constructor(
    val bloggerlink: String,
    val bloggername: String,
    val description: String,
    val display: Int,
    val items: List<NaverPost>,
    @Serializable(with = DateAsLongSerializer::class)
    val lastBuildDate: Date,
    val link: String,
    @Serializable(with = DateAsLongSerializer::class)
    val postdate: Date,
    val start: Int,
    val title: String,
    val total: Int
)
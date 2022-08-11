package kr.loner.hoomasjip.sooyeolsample.serialization

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

const val JSON_TEXT = """
    {
        "name": "Seoul"
    }
"""

@Serializable
data class ErrorExam(
    val name: String,
    val address: String = "Seoul"
)


fun main() {
    //Gson
    val token = object : TypeToken<ErrorExam>() {}.type
    val objectFromGson = Gson().fromJson<ErrorExam>(JSON_TEXT, token)
    println(objectFromGson)
    //Gson으로 사용하게 되면 address에 값은 null이 나온다.

    //kotlinx-serialization
    val objectFromKotilnxSerialization: ErrorExam =
        Json.decodeFromString(JSON_TEXT)
//    Json { coerceInputValues = true }.decodeFromString(JSON_TEXT)
    println(objectFromKotilnxSerialization)
    //하지만 kotlinx-serialization을 사용하면 address 값은 Seoul이 나오는 것을 볼 수 있다.
}
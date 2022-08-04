package kr.loner.paging3sample.data.api.model

data class Board(
    val title:String,
    val content:String
){
    companion object{
        val InitValue = Board("아이템이 없습니다.","아이템이 존재하지 않습니다.\n더 불러오세요")
    }
}

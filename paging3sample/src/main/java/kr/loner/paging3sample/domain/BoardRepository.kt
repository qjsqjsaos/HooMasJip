package kr.loner.paging3sample.domain


import kr.loner.paging3sample.shared.Board
import kr.loner.paging3sample.shared.SharedPagingData

interface BoardRepository {
    val getPagingBoardData: SharedPagingData<Board>
}
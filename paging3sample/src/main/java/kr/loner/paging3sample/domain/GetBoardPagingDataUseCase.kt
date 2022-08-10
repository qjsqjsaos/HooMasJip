package kr.loner.paging3sample.domain


import kr.loner.paging3sample.shared.Board
import kr.loner.paging3sample.shared.SharedPagingData


class GetBoardPagingDataUseCase(private val boardRepository: BoardRepository) {
    operator fun invoke():SharedPagingData<Board> = boardRepository.getPagingBoardData

}
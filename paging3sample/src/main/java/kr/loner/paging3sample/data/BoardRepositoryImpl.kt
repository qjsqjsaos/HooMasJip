package kr.loner.paging3sample.data

import androidx.paging.Pager
import androidx.paging.PagingConfig
import kr.loner.paging3sample.data.api.MockApiService
import kr.loner.paging3sample.shared.Board
import kr.loner.paging3sample.data.api.model.BoardPagingSource
import kr.loner.paging3sample.domain.BoardRepository
import kr.loner.paging3sample.shared.SharedPagingData

//힐트 적용 예정
class BoardRepositoryImpl(
    apiService: MockApiService,
) : BoardRepository {

    override val getPagingBoardData: SharedPagingData<Board> = SharedPagingData(Pager(
        PagingConfig(
            pageSize = MockApiService.DefaultSize,
        )
    ) {
        BoardPagingSource(apiService)
    }.flow)

}
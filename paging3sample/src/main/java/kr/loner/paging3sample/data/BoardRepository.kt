package kr.loner.paging3sample.data

import androidx.paging.Pager
import androidx.paging.PagingConfig
import kr.loner.paging3sample.data.api.MockApiService
import kr.loner.paging3sample.data.api.model.BoardPagingSource

//힐트 적용 예정
class BoardRepository(apiService: MockApiService) {
    val pagingDataModel = Pager(PagingConfig(
        pageSize = MockApiService.DefaultSize
    )){
        BoardPagingSource(apiService)
    }
}
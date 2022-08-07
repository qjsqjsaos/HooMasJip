package kr.loner.paging3sample.data.api

import kr.loner.paging3sample.App
import kr.loner.paging3sample.data.api.holder.ApiPagingDataModel
import kr.loner.paging3sample.shared.Board

class MockApiService {
    fun getDataModelListByExampleApiConnect(page: Int): ApiPagingDataModel<Board> {

        val prevListSize = (page * DefaultSize) - DefaultSize
        val nextListSize = page * DefaultSize
        return ApiPagingDataModel(
            App.dataModelList.subList(prevListSize, nextListSize).toList(),
            page
        )
    }

    companion object {
        const val DefaultSize = 10
    }
}
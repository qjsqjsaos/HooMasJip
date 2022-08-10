package kr.loner.paging3sample.data.api.holder

data class ApiPagingDataModel<T>(
    val data:List<T>,
    val page:Int
)

package kr.loner.paging3sample.shared

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow

data class SharedPagingData<T:Any>(
    val getPagingData: Flow<PagingData<T>>
)

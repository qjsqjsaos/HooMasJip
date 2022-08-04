package kr.loner.paging3sample.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kr.loner.paging3sample.data.BoardRepository
import kr.loner.paging3sample.data.api.model.Board

class MainViewModel(boardRepository: BoardRepository) : ViewModel() {
    val boardList: StateFlow<PagingData<Board>> = boardRepository.pagingDataModel.flow.stateIn(
        viewModelScope, SharingStarted.WhileSubscribed(),
        PagingData.empty()
    )


}
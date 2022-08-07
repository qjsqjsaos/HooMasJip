package kr.loner.paging3sample.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kr.loner.paging3sample.shared.Board
import kr.loner.paging3sample.domain.GetBoardPagingDataUseCase

class MainViewModel(getBoardPagingDataUseCase: GetBoardPagingDataUseCase) : ViewModel() {

    val boardList: StateFlow<PagingData<Board>> = getBoardPagingDataUseCase().getPagingData.stateIn(
        viewModelScope, SharingStarted.WhileSubscribed(),
        PagingData.empty()
    )
}
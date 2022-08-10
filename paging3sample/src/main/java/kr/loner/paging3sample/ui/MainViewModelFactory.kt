package kr.loner.paging3sample.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kr.loner.paging3sample.data.BoardRepositoryImpl
import kr.loner.paging3sample.data.api.MockApiService
import kr.loner.paging3sample.domain.GetBoardPagingDataUseCase
import java.lang.IllegalArgumentException

class MainViewModelFactory(private val getBoardPagingDataUseCase: GetBoardPagingDataUseCase) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            MainViewModel(getBoardPagingDataUseCase) as T
        } else {
            throw IllegalArgumentException("MainViewModel is require Factory")
        }
    }
    companion object{
        val createUseCase = MainViewModelFactory(
            GetBoardPagingDataUseCase(
                BoardRepositoryImpl(
                    MockApiService()
                )
            )
        )
    }
}
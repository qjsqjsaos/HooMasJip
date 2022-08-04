package kr.loner.paging3sample.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kr.loner.paging3sample.data.BoardRepository
import java.lang.IllegalArgumentException

class MainViewModelFactory(private val boardRepository: BoardRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            MainViewModel(boardRepository) as T
        } else {
            throw IllegalArgumentException("MainViewModel is require Factory")
        }
    }
}
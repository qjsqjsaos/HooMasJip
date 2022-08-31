package com.example.apisample.presentation.ui

import androidx.lifecycle.viewModelScope
import com.example.apisample.domain.usecase.GetBlogListUseCase
import com.example.apisample.presentation.base.BaseViewModel
import com.example.apisample.presentation.widget.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import com.example.apisample.shared.blog.Blog
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SooyeolViewModel @Inject constructor(
    private val getBlogListUseCase: GetBlogListUseCase
)  : BaseViewModel() {

    private val _uiState  = MutableStateFlow<UiState>(UiState.Loading)
    val state : StateFlow<UiState> = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            try {
                val list = getBlogList("광명")
                if(list.isNotEmpty()) {
                    _uiState.value = UiState.Success(list)
                } else {
                    _uiState.value = UiState.Failure(Throwable("listEmpty"))
                }
            }catch (e : Throwable){
                _uiState.value = UiState.Failure(e)
            }
        }
    }


    private suspend fun getBlogList(search: String): List<Blog> {
        return getBlogListUseCase.getBlogDataList(search)
    }

}
package kr.loner.hoomasjip.sample.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kr.loner.domain.usecase.GetFakeBlogListUseCase
import kr.loner.hoomasjip.sample.model.UiStateSample

class SampleViewModel(private val getFakeBlogListUseCase: GetFakeBlogListUseCase):ViewModel() {
    private val _uiState  = MutableStateFlow<UiStateSample>(UiStateSample.Loading)
    val state : StateFlow<UiStateSample> = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            _uiState.value = UiStateSample.Loading
            try{
                val result = getFakeBlogListUseCase()
                _uiState.value = UiStateSample.Success(result)
            }catch (e : Throwable){
                _uiState.value = UiStateSample.Failure(e)
            }
        }
    }
}


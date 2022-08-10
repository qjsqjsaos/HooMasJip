package kr.loner.hoomasjip.sample.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kr.loner.domain.usecase.GetFakeBlogListUseCase
import kr.loner.hoomasjip.sample.model.UiStateSample
import kr.loner.shared.model.FakeBlog

class SampleViewModel(private val getFakeBlogListUseCase: GetFakeBlogListUseCase):ViewModel() {

    val fakeBlogList: LiveData<UiStateSample<List<FakeBlog>>> = liveData{
        emit(UiStateSample.loading())
        emit(UiStateSample.success(getFakeBlogListUseCase()))
    }

//    private val _uiState  = MutableStateFlow<UiStateSample>(UiStateSample.Loading)
//    val state : StateFlow<UiStateSample> = _uiState.asStateFlow()
//
//    init {
//        viewModelScope.launch {
//            _uiState.value = UiStateSample.Loading
//            try{
//                val result = getFakeBlogListUseCase()
//                _uiState.value = UiStateSample.Success(result)
//            }catch (e : Throwable){
//                _uiState.value = UiStateSample.Failure(e)
//            }
//        }
//    }
}


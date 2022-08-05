package kr.loner.hoomasjip.sample.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import kr.loner.domain.usecase.GetFakeBlogListUseCase
import kr.loner.hoomasjip.sample.model.UiStateSample
import kr.loner.shared.model.FakeBlog

class SampleViewModel(private val getFakeBlogListUseCase: GetFakeBlogListUseCase):ViewModel() {
    val fakeBlogList:LiveData<UiStateSample<List<FakeBlog>>> = liveData{
        emit(UiStateSample.loading())
        emit(UiStateSample.success(getFakeBlogListUseCase()))
    }
}


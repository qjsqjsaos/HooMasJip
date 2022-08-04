package kr.loner.hoomasjip.sample.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import kr.loner.domain.usecase.GetFakeBlogListUseCase
import kr.loner.hoomasjip.sample.model.UiStateSample
import kr.loner.shared.model.Blog

class SampleViewModel(private val getFakeBlogListUseCase: GetFakeBlogListUseCase):ViewModel() {
    val blogList:LiveData<UiStateSample<List<Blog>>> = liveData{
        emit(UiStateSample.loading())
        emit(UiStateSample.success(getFakeBlogListUseCase()))
    }
}


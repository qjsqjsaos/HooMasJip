package kr.loner.hoomasjip.sooyeolsample.presentation.ui.fragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import dagger.hilt.android.lifecycle.HiltViewModel
import kr.loner.hoomasjip.sooyeolsample.domain.usecase.GetBlogListUseCase
import kr.loner.hoomasjip.sample.model.UiStateSample
import kr.loner.hoomasjip.sooyeolsample.presentation.base.BaseViewModel
import kr.loner.shared.model.FakeBlog
import javax.inject.Inject


@HiltViewModel
class SooyeolFragViewModel @Inject constructor(
    private val getBlogListUseCase: GetBlogListUseCase
) : BaseViewModel() {

    val fakeBlogList: LiveData<UiStateSample<List<FakeBlog>>> = liveData{
        emit(UiStateSample.loading())
        emit(UiStateSample.success(getBlogListUseCase()))
    }

}
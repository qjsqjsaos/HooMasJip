package kr.loner.hoomasjip.sooyeolsample.presentation.ui.fragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import dagger.hilt.android.lifecycle.HiltViewModel
import kr.loner.hoomasjip.sooyeolsample.domain.usecase.GetBlogListUseCase
import kr.loner.hoomasjip.sample.model.UiStateSample
import kr.loner.hoomasjip.sooyeolsample.presentation.base.BaseViewModel
import kr.loner.shared.model.Blog
import javax.inject.Inject


@HiltViewModel
class SooyeolFragViewModel @Inject constructor(
    private val getBlogListUseCase: GetBlogListUseCase
) : BaseViewModel() {

    val blogList: LiveData<UiStateSample<List<Blog>>> = liveData{
        emit(UiStateSample.loading())
        emit(UiStateSample.success(getBlogListUseCase()))
    }

}
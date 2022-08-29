package kr.loner.hoomasjip.sooyeolsample.presentation.ui

import androidx.lifecycle.LiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.scopes.ViewModelScoped
import kr.loner.domain.sooyeolapi.usecase.GetBlogListUseCase
import kr.loner.hoomasjip.sooyeolsample.presentation.base.BaseViewModel
import kr.loner.hoomasjip.sooyeolsample.presentation.widget.utils.SingleLiveEvent
import kr.loner.shared.model.sooyeol.blog.Blog

class SooyeolViewModel(private val userCase: GetBlogListUseCase) : BaseViewModel() {

    private val _screenWhenTemp = SingleLiveEvent<Unit>()
    val screenWhenTemp: LiveData<Unit> = _screenWhenTemp

    fun openFragment() = _screenWhenTemp.call()

    suspend fun getBlogList(): Blog? {
        return userCase.getBlogDataList(
            "광명 맛집",
            10,
            1,
            "sim"
        )
    }

}
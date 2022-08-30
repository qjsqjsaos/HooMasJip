package com.example.apisample.presentation.ui

import androidx.lifecycle.LiveData
import com.example.apisample.domain.usecase.GetBlogListUseCase
import com.example.apisample.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kr.loner.hoomasjip.sooyeolsample.presentation.widget.utils.SingleLiveEvent
import com.example.apisample.shared.blog.Blog
import javax.inject.Inject

@HiltViewModel
class SooyeolViewModel @Inject constructor(
    private val getBlogListUseCase: GetBlogListUseCase
)  : BaseViewModel() {

    private val _screenWhenTemp = SingleLiveEvent<Unit>()
    val screenWhenTemp: LiveData<Unit> = _screenWhenTemp

    fun openFragment() = _screenWhenTemp.call()

    suspend fun getBlogList(search: String): List<Blog> {
        return getBlogListUseCase.getBlogDataList(search)
    }

}
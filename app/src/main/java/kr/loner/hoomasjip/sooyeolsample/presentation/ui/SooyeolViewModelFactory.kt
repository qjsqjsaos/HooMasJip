package kr.loner.hoomasjip.sooyeolsample.presentation.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kr.loner.data.repository.FakeBlogRepositoryImpl
import kr.loner.data.sooyeolapi.repository.BlogRepositoryImpl
import kr.loner.domain.sooyeolapi.usecase.GetBlogListUseCase
import kr.loner.domain.usecase.GetFakeBlogListUseCase
import kr.loner.hoomasjip.sample.ui.SampleViewModel
import java.lang.IllegalArgumentException

class SooyeolViewModelFactory: ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(SooyeolViewModel::class.java)){
            return SooyeolViewModel(GetBlogListUseCase(BlogRepositoryImpl())) as T
        }else{
            throw IllegalArgumentException()
        }
    }
}
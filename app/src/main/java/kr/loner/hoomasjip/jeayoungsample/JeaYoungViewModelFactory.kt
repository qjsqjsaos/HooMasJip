package kr.loner.hoomasjip.jeayoungsample

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kr.loner.data.repository.FakeBlogRepositoryImpl
import kr.loner.domain.usecase.GetFakeBlogListUseCase
import kr.loner.hoomasjip.sample.ui.SampleViewModel
import java.lang.IllegalArgumentException

class JeaYoungViewModelFactory: ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(JeaYoungViewModel::class.java)){
            return JeaYoungViewModel(GetFakeBlogListUseCase(FakeBlogRepositoryImpl)) as T
        }else{
            throw IllegalArgumentException()
        }
    }
}
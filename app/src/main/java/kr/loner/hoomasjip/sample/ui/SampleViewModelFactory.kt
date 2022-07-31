package kr.loner.hoomasjip.sample.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kr.loner.data.repository.FakeBlogRepositoryImpl
import kr.loner.domain.usecase.GetFakeBlogListUseCase
import java.lang.IllegalArgumentException

class SampleViewModelFactory: ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(SampleViewModel::class.java)){
            return SampleViewModel(GetFakeBlogListUseCase(FakeBlogRepositoryImpl)) as T
        }else{
            throw IllegalArgumentException()
        }
    }

}
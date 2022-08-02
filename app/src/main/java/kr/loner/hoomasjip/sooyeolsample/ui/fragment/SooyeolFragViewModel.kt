package kr.loner.hoomasjip.sooyeolsample.ui.fragment

import dagger.hilt.android.lifecycle.HiltViewModel
import kr.loner.domain.usecase.GetFakeBlogListUseCase
import kr.loner.hoomasjip.sooyeolsample.base.BaseViewModel
import javax.inject.Inject

@HiltViewModel
class SooyeolFragViewModel @Inject constructor(
    private val getFakeBlogListUseCase: GetFakeBlogListUseCase
) : BaseViewModel() {

}
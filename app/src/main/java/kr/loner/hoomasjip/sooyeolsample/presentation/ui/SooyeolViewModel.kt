package kr.loner.hoomasjip.sooyeolsample.presentation.ui

import androidx.lifecycle.LiveData
import kr.loner.hoomasjip.sooyeolsample.presentation.base.BaseViewModel
import kr.loner.hoomasjip.sooyeolsample.presentation.widget.utils.SingleLiveEvent

class SooyeolViewModel : BaseViewModel() {

    private val _screenWhenTemp = SingleLiveEvent<Unit>()
    val screenWhenTemp: LiveData<Unit> = _screenWhenTemp

    fun openFragment() = _screenWhenTemp.call()

}
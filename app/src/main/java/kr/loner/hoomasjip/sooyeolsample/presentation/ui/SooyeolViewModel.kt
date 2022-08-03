package kr.loner.hoomasjip.sooyeolsample.presentation.ui

import androidx.lifecycle.LiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import kr.loner.hoomasjip.sooyeolsample.presentation.base.BaseViewModel
import kr.loner.hoomasjip.sooyeolsample.presentation.widget.utils.SingleLiveEvent

class SooyeolViewModel : BaseViewModel() {

    private val _frag = SingleLiveEvent<Unit>()
    val frag: LiveData<Unit> = _frag

    fun openFragment() = _frag.call()

}
package kr.loner.hoomasjip.sooyeolsample.ui.fragment

import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import kr.loner.hoomasjip.R
import kr.loner.hoomasjip.databinding.FragmentSooyeolBinding
import kr.loner.hoomasjip.sooyeolsample.base.BaseFragment

@AndroidEntryPoint
class SooyeolFragment : BaseFragment<FragmentSooyeolBinding, SooyeolFragViewModel>(
    R.layout.fragment_sooyeol
) {
    override val viewModel: SooyeolFragViewModel by viewModels()

}
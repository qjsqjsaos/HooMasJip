package kr.loner.hoomasjip.sooyeolsample.presentation.ui.fragment

import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import kr.loner.hoomasjip.R
import kr.loner.hoomasjip.databinding.FragmentSooyeolBinding
import kr.loner.hoomasjip.sooyeolsample.presentation.base.BaseFragment
import kr.loner.hoomasjip.sooyeolsample.presentation.widget.extension.addChildUiFromFakeBlog

@AndroidEntryPoint
class SooyeolFragment : BaseFragment<FragmentSooyeolBinding, SooyeolFragViewModel>(
    R.layout.fragment_sooyeol
) {
    override val viewModel: SooyeolFragViewModel by viewModels()

    override fun initLiveData() {
        viewModel.fakeBlogList.observe(this) { uiFakeBlogs ->
            binding.fakeBlogs.addChildUiFromFakeBlog(uiFakeBlogs.data.orEmpty())
        }
    }
}
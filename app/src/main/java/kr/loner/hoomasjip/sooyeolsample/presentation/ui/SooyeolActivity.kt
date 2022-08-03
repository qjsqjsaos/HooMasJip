package kr.loner.hoomasjip.sooyeolsample.presentation.ui

import android.content.Context
import android.content.Intent
import androidx.activity.viewModels
import dagger.hilt.android.AndroidEntryPoint
import kr.loner.hoomasjip.R
import kr.loner.hoomasjip.databinding.ActivitySooyeolBinding
import kr.loner.hoomasjip.sooyeolsample.presentation.base.BaseActivity
import kr.loner.hoomasjip.sooyeolsample.presentation.ui.fragment.SooyeolFragment

@AndroidEntryPoint
class SooyeolActivity : BaseActivity<ActivitySooyeolBinding, SooyeolViewModel>(R.layout.activity_sooyeol) {

    override val viewModel: SooyeolViewModel by viewModels()

    companion object {
        fun newIntent(context: Context?): Intent = Intent(context, SooyeolActivity::class.java)
    }

    override fun initLiveData() {
        viewModel.frag.observe(this) {
            supportFragmentManager
                .beginTransaction()
                .add(android.R.id.content, SooyeolFragment())
                .addToBackStack(null)
                .commit()
        }
    }
}
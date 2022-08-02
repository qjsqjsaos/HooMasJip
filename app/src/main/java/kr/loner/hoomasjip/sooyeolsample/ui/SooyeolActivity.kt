package kr.loner.hoomasjip.sooyeolsample.ui

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import dagger.hilt.android.AndroidEntryPoint
import kr.loner.hoomasjip.R
import kr.loner.hoomasjip.databinding.ActivitySooyeolBinding
import kr.loner.hoomasjip.sooyeolsample.base.BaseActivity

@AndroidEntryPoint
class SooyeolActivity : BaseActivity<ActivitySooyeolBinding, SooyeolViewModel>(R.layout.activity_sooyeol) {

    override val viewModel: SooyeolViewModel by viewModels()

    companion object {
        fun newIntent(context: Context?): Intent = Intent(context, SooyeolActivity::class.java)
    }
}
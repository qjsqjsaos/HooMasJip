package kr.loner.hoomasjip.sooyeolsample.presentation.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import kr.loner.hoomasjip.R
import kr.loner.hoomasjip.databinding.ActivitySooyeolBinding
import kr.loner.hoomasjip.sooyeolsample.presentation.base.BaseActivity


class SooyeolActivity : BaseActivity<ActivitySooyeolBinding>(R.layout.activity_sooyeol) {


    companion object {
        fun newIntent(context: Context?): Intent = Intent(context, SooyeolActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel = ViewModelProvider(this, SooyeolViewModelFactory())[SooyeolViewModel::class.java]
        //onCreate override 하여 사용하기
        lifecycleScope.launch {
            val test = viewModel.getBlogList()
            shortShowToast(test.toString())
        }
    }

}
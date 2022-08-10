package kr.loner.hoomasjip.sample.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import kr.loner.hoomasjip.R
import kr.loner.hoomasjip.databinding.ActivitySampleBinding
import kr.loner.hoomasjip.sample.model.UiStateSample
import kr.loner.hoomasjip.sample.util.toResColor
import kr.loner.shared.model.FakeBlog

class SampleActivity : AppCompatActivity() {
    private val viewModel by viewModels<SampleViewModel> { SampleViewModelFactory() }
    private val binding by lazy {
        DataBindingUtil.setContentView<ActivitySampleBinding>(this,R.layout.activity_sample)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sample)
        binding.vm = viewModel
        binding.lifecycleOwner = this
    }

}

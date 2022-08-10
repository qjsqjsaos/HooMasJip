package kr.loner.hoomasjip.sample.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import kr.loner.hoomasjip.R
import kr.loner.hoomasjip.sample.model.UiStateSample
import kr.loner.hoomasjip.sample.util.toResColor
import kr.loner.shared.model.FakeBlog

class SampleActivity : ComponentActivity() {
    private val viewModel by viewModels<SampleViewModel> { SampleViewModelFactory() }
    private val loadingBar by lazy {
        findViewById<ProgressBar>(R.id.progress_loading)
    }
    private val itemGroupLayout by lazy {
        findViewById<LinearLayout>(R.id.fakeBlogs)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sample)
        lifecycleScope.launch {
            viewModel.state.collect{ state ->
                if(state is UiStateSample.Loading){
                    loadingBar.visibility = View.VISIBLE
                }
                if(state is UiStateSample.Success<*>){
                    loadingBar.visibility = View.GONE
                    itemGroupLayout.addChildUiFromFakeBlog(state.data as List<FakeBlog>)
                }else{}
            }
        }
    }

    private fun LinearLayout.addChildUiFromFakeBlog(fakeBlogList: List<FakeBlog>) {
        fakeBlogList.forEach {
            val item =
                LayoutInflater.from(this@SampleActivity).inflate(R.layout.item_sample, this, false)
            val title = item.findViewById<TextView>(R.id.tv_title)
            val content = item.findViewById<TextView>(R.id.tv_content)

            item.setBackgroundColor(it.color.toResColor())
            title.text = it.title
            content.text = it.desc
            addView(item, 0)
        }
    }
}

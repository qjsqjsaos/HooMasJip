package kr.loner.hoomasjip.jeayoungsample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import kr.loner.domain.usecase.GetFakeBlogListUseCase
import kr.loner.hoomasjip.R
import kr.loner.hoomasjip.sample.util.toResColor
import kr.loner.shared.model.FakeBlog

class JeaYoungActivity :
    AppCompatActivity() {
    private val viewModel by viewModels<JeaYoungViewModel> { JeaYoungViewModelFactory() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jeayoung)
        val loadingBar = findViewById<ProgressBar>(R.id.loadingBar)
        val itemGroupLayout = findViewById<LinearLayout>(R.id.itemGroupLayout)
        lifecycleScope.launch {
            viewModel.state.collect { state ->
                if (state is UiStateSample.Loading) {
                    loadingBar.visibility = View.VISIBLE
                }
                if (state is UiStateSample.Success<*>) {
                    loadingBar.visibility = View.GONE
                    itemGroupLayout.addChildUiFromFakeBlog(state.data as List<FakeBlog>)
                } else {
                }
            }
        }
    }

    private fun LinearLayout.addChildUiFromFakeBlog(fakeBlogList: List<FakeBlog>) {
        fakeBlogList.forEach {
            val item =
                LayoutInflater.from(this.context).inflate(R.layout.item_sample, this, false)
            val title = item.findViewById<TextView>(R.id.tv_title)
            val content = item.findViewById<TextView>(R.id.tv_content)

            item.setBackgroundColor(it.color.toResColor())
            title.text = it.title
            content.text = it.desc
            addView(item, 0)
        }
    }
}
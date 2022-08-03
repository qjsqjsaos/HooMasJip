package kr.loner.hoomasjip.sooyeolsample.presentation.widget.extension

import android.view.LayoutInflater
import android.widget.FrameLayout
import android.widget.TextView
import kr.loner.hoomasjip.R
import kr.loner.hoomasjip.sample.util.toResColor
import kr.loner.shared.model.FakeBlog

fun FrameLayout.addChildUiFromFakeBlog(fakeBlogList: List<FakeBlog>) {
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
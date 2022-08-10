package kr.loner.hoomasjip.sample.ui

import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import kr.loner.hoomasjip.R
import kr.loner.hoomasjip.databinding.ItemSampleBinding
import kr.loner.hoomasjip.sample.util.toResColor
import kr.loner.shared.model.FakeBlog

@BindingAdapter("sampleAddItemView")
fun LinearLayout.sampleAddItemView(fakeBlogList: List<FakeBlog>?) {
    fakeBlogList?.forEach {
        val item = DataBindingUtil.inflate<ItemSampleBinding>(
            LayoutInflater.from(this.context),
            R.layout.item_sample,
            this,
            false
        )
        item.fakeBlog = it
        item.root.setBackgroundColor(it.color.toResColor())
        addView(item.root, 0)
    }
}

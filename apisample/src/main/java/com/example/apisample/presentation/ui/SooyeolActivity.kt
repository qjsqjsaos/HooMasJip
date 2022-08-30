package com.example.apisample.presentation.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.example.apisample.R
import com.example.apisample.databinding.ActivitySooyeolBinding
import kotlinx.coroutines.launch
import com.example.apisample.presentation.base.BaseActivity
import com.example.apisample.presentation.ui.adapter.BlogListAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SooyeolActivity : BaseActivity<ActivitySooyeolBinding, SooyeolViewModel>(R.layout.activity_sooyeol) {

    override val viewModel: SooyeolViewModel by viewModels()

    companion object {
        fun newIntent(context: Context?): Intent = Intent(context, SooyeolActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifecycleScope.launch {
            val list = viewModel.getBlogList("광명")
            Log.d("리스트", list.toString())
            binding.recyclerView.apply {
                setHasFixedSize(true)
                layoutManager = GridLayoutManager(this@SooyeolActivity, 2)
                adapter = BlogListAdapter(list)
            }
        }
    }

}
package com.example.apisample.presentation.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.example.apisample.R
import com.example.apisample.databinding.ActivitySooyeolBinding
import kotlinx.coroutines.launch
import com.example.apisample.presentation.base.BaseActivity
import com.example.apisample.presentation.ui.adapter.BlogListAdapter
import com.example.apisample.presentation.widget.UiState
import com.example.apisample.shared.blog.Blog
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SooyeolActivity : BaseActivity<ActivitySooyeolBinding, SooyeolViewModel>(R.layout.activity_sooyeol) {

    override val viewModel: SooyeolViewModel by viewModels()

    companion object {
        fun newIntent(context: Context?): Intent = Intent(context, SooyeolActivity::class.java)
    }

    override fun initObserve() {
        lifecycleScope.launch {
            viewModel.state.collect { state ->
                if (state is UiState.Loading) {
                    binding.loadingBar.visibility = View.VISIBLE
                    return@collect
                }
                else if (state is UiState.Success<*>) {
                    binding.recyclerView.apply {
                        setHasFixedSize(true)
                        layoutManager = GridLayoutManager(this@SooyeolActivity, 2)
                        adapter = BlogListAdapter(state.data as List<Blog>)
                    }
                } else {
                    shortShowToast((state as UiState.Failure).exception?.message!!)
                }
                binding.loadingBar.visibility = View.GONE
            }
        }
    }
}
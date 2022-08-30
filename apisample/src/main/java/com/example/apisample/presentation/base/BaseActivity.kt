package com.example.apisample.presentation.base

import android.os.Bundle
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.example.apisample.BR

abstract class BaseActivity<V : ViewDataBinding, VM : BaseViewModel>(
    @LayoutRes private val layoutResId: Int
) : AppCompatActivity() {

    private var waitTime = 0L

    lateinit var binding: V

    abstract val viewModel: VM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, layoutResId)
        binding.setVariable(BR.vm, viewModel)
        binding.lifecycleOwner = this

        initObserve()
        initListener()
    }

    open fun initObserve() {}

    open fun initListener() {}

    override fun onBackPressed() {
        if (System.currentTimeMillis() - waitTime >= 1500) {
            waitTime = System.currentTimeMillis()
            shortShowToast("뒤로가기 버튼을 한번 더 누르면 종료됩니다.")
        } else finish()
    }

    protected fun shortShowToast(msg: String) =
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()

    protected fun longShowToast(msg: String) =
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
}
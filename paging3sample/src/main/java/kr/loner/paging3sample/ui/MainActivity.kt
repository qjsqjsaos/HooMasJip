package kr.loner.paging3sample.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import kr.loner.paging3sample.R

class MainActivity : AppCompatActivity() {
    private val mainAdapter = MainAdapter()
    private val viewModel by viewModels<MainViewModel> { MainViewModelFactory.createUseCase }
    private val rvBoardList by lazy {
        findViewById<RecyclerView>(R.id.rv_boardList)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.boardList.collectLatest { board ->
                    rvBoardList.apply {
                        if (adapter == null) adapter = mainAdapter
                        mainAdapter.submitData(board)
                    }
                }
            }
        }

    }
}
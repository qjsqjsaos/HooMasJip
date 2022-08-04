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
import kr.loner.paging3sample.data.BoardRepository
import kr.loner.paging3sample.data.api.MockApiService

class MainActivity : AppCompatActivity() {
    private val mainAdapter = MainAdapter()
    private val viewModel by viewModels<MainViewModel> {
        MainViewModelFactory(
            BoardRepository(
                MockApiService()
            )
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.boardList.collectLatest { board ->
                    findViewById<RecyclerView>(R.id.rv_datas).apply {
                        if(adapter == null) {
                            adapter = mainAdapter
                        }else{
                            mainAdapter.submitData(board)
                        }
                    }
                }
            }
        }

    }
}
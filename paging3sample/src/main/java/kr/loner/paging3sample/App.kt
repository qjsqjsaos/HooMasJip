package kr.loner.paging3sample

import android.app.Application
import kr.loner.paging3sample.data.api.model.Board

class App: Application() {
    override fun onCreate() {
        super.onCreate()
        setUpMockList()
    }

    private fun setUpMockList() {
        repeat(1000) { pos ->
            val contentWhenIsList = Array(20) { pos.toString() }
            dataModelList.add(
                Board(
                    title = "${pos}번 아이템",
                    content = contentWhenIsList.joinToString()
                )
            )
        }
    }

    companion object{
        val dataModelList = mutableListOf<Board>()
    }
}
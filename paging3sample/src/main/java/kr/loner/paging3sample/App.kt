package kr.loner.paging3sample

import android.app.Application
import kr.loner.paging3sample.shared.Board

class App: Application() {
    override fun onCreate() {
        super.onCreate()
        setUpMockList()
    }

    private fun setUpMockList() {
        repeat(1000) { pos ->
            dataModelList.add(Board(title = "${pos+1}번 아이템"))
        }
    }

    companion object{
        val dataModelList = mutableListOf<Board>()
    }
}
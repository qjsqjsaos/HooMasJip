package kr.loner.paging3sample.data.api.model

import androidx.paging.PagingSource
import androidx.paging.PagingState
import kr.loner.paging3sample.data.api.MockApiService
import java.lang.Exception
import java.lang.NullPointerException

//힐트 적용 예정
class BoardPagingSource(
    private val api: MockApiService
) : PagingSource<Int, Board>() {
    override suspend fun load(
        params: LoadParams<Int>
    ): LoadResult<Int, Board> {
        return try {
            val nextPageNumber = params.key ?: 1
            val apiResult = api.getDataModelListByExampleApiConnect(nextPageNumber)
            LoadResult.Page(
                data = apiResult.data,
                prevKey = null,
                nextKey = apiResult.page
            )
            //레트로핏의 HttpException 처리를 나중에 여기서 하면 좋을 것 같습니다.
        }catch (e:Exception){
            LoadResult.Error(e.cause?:throw NullPointerException("Network Response Empty"))
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Board>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }
}

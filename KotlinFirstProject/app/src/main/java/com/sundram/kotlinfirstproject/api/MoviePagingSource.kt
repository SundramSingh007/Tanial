package com.sundram.kotlinfirstproject.api

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.sundram.kotlinfirstproject.datamodel.Search
import com.sundram.kotlinfirstproject.util.ConstantUtils.Companion.API_KEY
import com.sundram.kotlinfirstproject.util.ConstantUtils.Companion.TYPE
import retrofit2.HttpException
import java.lang.Exception

private const val STARTING_PAGE_INDEX = 1;

class MoviePagingSource(private val services: ApiServices, private val query: String) :
    PagingSource<Int, Search>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Search> {
        val position = params.key ?: STARTING_PAGE_INDEX
        val apiQuery: String = query

        return try {
            val response = services.searchMovie(API_KEY, apiQuery, TYPE, position)
            val data = response.search
            val nextKey = if (data.isEmpty()) {
                null
            } else {
                position + (params.loadSize / STARTING_PAGE_INDEX)
            }
            LoadResult.Page(
                data = data,
                prevKey = if (position == STARTING_PAGE_INDEX) null else position - 1,
                nextKey = nextKey
            )
        } catch (e: Exception) {
            return LoadResult.Error(e)
        } catch (e: HttpException) {
            return LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Search>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.plus(1)
        }
    }

}
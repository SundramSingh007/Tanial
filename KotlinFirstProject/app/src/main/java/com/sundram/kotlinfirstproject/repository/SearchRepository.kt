package com.sundram.kotlinfirstproject.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.sundram.kotlinfirstproject.api.ApiServices
import com.sundram.kotlinfirstproject.api.MoviePagingSource
import com.sundram.kotlinfirstproject.datamodel.Search
import kotlinx.coroutines.flow.Flow

class SearchRepository(private val apiServices: ApiServices) {

    fun getSearchResult(query: String): Flow<PagingData<Search>> {
        return Pager(
            config = PagingConfig(
                pageSize = NETWORK_PAGE_SIZE,
                enablePlaceholders = false
            ),
            pagingSourceFactory = { MoviePagingSource(apiServices, query) }
        ).flow
    }

    companion object {
        const val NETWORK_PAGE_SIZE = 30
    }
}
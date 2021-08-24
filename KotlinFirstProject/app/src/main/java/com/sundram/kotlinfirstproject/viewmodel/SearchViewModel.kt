package com.sundram.kotlinfirstproject.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.sundram.kotlinfirstproject.datamodel.Search
import com.sundram.kotlinfirstproject.repository.SearchRepository
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class SearchViewModel(
    private val repository: SearchRepository,
    private val savedStateHandle: SavedStateHandle
) :
    ViewModel() {

    val state: StateFlow<UiState>

    val accept: (UiAction) -> Unit

    init {
        val initQuery: String = savedStateHandle.get(LAST_SEARCH_QUERY) ?: DEFAULT_QUERY
        val lastQueryScrolled: String = savedStateHandle.get(LAST_QUERY_SCROLLED) ?: DEFAULT_QUERY

        val actionStateFlow = MutableSharedFlow<UiAction>()

        val searches = actionStateFlow.filterIsInstance<UiAction.Search>().distinctUntilChanged()

        val queryScrolled =
            actionStateFlow.filterIsInstance<UiAction.Scroll>().distinctUntilChanged()
                .shareIn(
                    scope = viewModelScope,
                    started = SharingStarted.WhileSubscribed(stopTimeoutMillis = 5000)
                )
                .onStart { emit(UiAction.Scroll(currentQuery = lastQueryScrolled)) }

        state = searches.flatMapLatest { search ->
            combine(queryScrolled, searchMovie(queryString = search.query), ::Pair)
                .distinctUntilChangedBy { it.second }
                .map { (scroll, pagingData) ->
                    UiState(
                        query = search.query,
                        pagingData = pagingData,
                        lastQueryScrolled = scroll.currentQuery,
                        // If the search query matches the scroll query, the user has scrolled
                        hasNotScrolledForCurrentSearch = search.query != scroll.currentQuery
                    )
                }
        }.stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(stopTimeoutMillis = 5000),
            initialValue = UiState()
        )

        accept = { action -> viewModelScope.launch { actionStateFlow.emit(action) } }
    }


    override fun onCleared() {
        savedStateHandle[LAST_SEARCH_QUERY] = state.value.query
        savedStateHandle[LAST_QUERY_SCROLLED] = state.value.lastQueryScrolled
        super.onCleared()
    }

    private fun searchMovie(queryString: String): Flow<PagingData<Search>> =
        repository.getSearchResult(queryString).cachedIn(viewModelScope)
}

sealed class UiAction {
    data class Search(val query: String) : UiAction()
    data class Scroll(val currentQuery: String) : UiAction()
}

data class UiState(
    val query: String = DEFAULT_QUERY,
    val lastQueryScrolled: String = DEFAULT_QUERY,
    val hasNotScrolledForCurrentSearch: Boolean = false,
    val pagingData: PagingData<Search> = PagingData.empty()
)

private const val LAST_SEARCH_QUERY: String = "last_search_query"
private const val DEFAULT_QUERY = "Avenger"
private const val LAST_QUERY_SCROLLED: String = "last_query_scrolled"
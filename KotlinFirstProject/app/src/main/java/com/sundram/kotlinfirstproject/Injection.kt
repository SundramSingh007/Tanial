package com.sundram.kotlinfirstproject

import androidx.lifecycle.ViewModelProvider
import androidx.savedstate.SavedStateRegistryOwner
import com.sundram.kotlinfirstproject.api.ApiServices
import com.sundram.kotlinfirstproject.repository.SearchRepository
import com.sundram.kotlinfirstproject.ui.ViewModelFactory

object Injection {
    private fun provideSearchRepository(): SearchRepository {
        return SearchRepository(ApiServices.create())
    }

    private fun provideViewModelFactory(owner: SavedStateRegistryOwner): ViewModelProvider.Factory {
        return ViewModelFactory(owner, provideSearchRepository())
    }
}
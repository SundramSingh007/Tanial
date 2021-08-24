package com.sundram.kotlinfirstproject.ui.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.sundram.kotlinfirstproject.databinding.MovieItemBinding
import com.sundram.kotlinfirstproject.datamodel.Search
import com.sundram.kotlinfirstproject.repository.SearchRepository

class SearchViewHolder(private val view: MovieItemBinding) : RecyclerView.ViewHolder(view.root) {

    private var repository: SearchRepository? = null

    init {
    }

    fun bind(search: Search) {
        if (search != null) {
//            view.searchData(search)
        }
    }

    companion object {
        fun create(binding: MovieItemBinding): SearchViewHolder {
            return SearchViewHolder(binding)
        }
    }
}
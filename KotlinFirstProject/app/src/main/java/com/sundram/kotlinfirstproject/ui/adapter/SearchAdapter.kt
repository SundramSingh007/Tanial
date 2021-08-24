package com.sundram.kotlinfirstproject.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import com.sundram.kotlinfirstproject.databinding.MovieItemBinding
import com.sundram.kotlinfirstproject.datamodel.Search
import com.sundram.kotlinfirstproject.ui.viewholder.SearchViewHolder

class SearchAdapter : PagingDataAdapter<Search, SearchViewHolder>(SEARCH_COMPARATOR){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
      return SearchViewHolder.create(MovieItemBinding.inflate(LayoutInflater.from(parent.context),parent,null))
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        val getItem=getItem(position)
        if (getItem!=null){
            holder.bind(getItem)
        }
    }

    companion object {
        private val SEARCH_COMPARATOR = object : DiffUtil.ItemCallback<Search>() {
            override fun areItemsTheSame(oldItem: Search, newItem: Search): Boolean =
                oldItem.title == newItem.title

            override fun areContentsTheSame(oldItem: Search, newItem: Search): Boolean =
                oldItem == newItem
        }
    }

}
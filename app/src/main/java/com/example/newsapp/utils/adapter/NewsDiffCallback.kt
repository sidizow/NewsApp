package com.example.newsapp.utils.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.newsapp.domain.entities.NewsEntity

class NewsDiffCallback(
    private val oldList: List<NewsEntity>,
    private val newList: List<NewsEntity>,
) : DiffUtil.Callback() {
    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {

        return oldList[oldItemPosition].title == newList[newItemPosition].title
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]
    }
}
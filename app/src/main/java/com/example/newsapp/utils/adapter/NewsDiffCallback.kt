package com.example.newsapp.utils.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.newsapp.domain.entities.DataItem

class NewsDiffCallback(
    private val oldList: List<DataItem>,
    private val newList: List<DataItem>,
) : DiffUtil.Callback() {
    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].hashCode() == newList[newItemPosition].hashCode()
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]
    }
}
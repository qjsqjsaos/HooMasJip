package com.example.apisample.presentation.ui.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.apisample.shared.blog.Blog

class DiffUtilCallback<T>(private val oldList: List<T>, private val currentList: List<T>) : DiffUtil.Callback(){

    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = currentList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldItem = oldList[oldItemPosition]
        val newItem = currentList[newItemPosition]

        return if(oldItem is Blog && newItem is Blog) {
            oldItem.id == newItem.id
        } else {
            false
        }
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == currentList[newItemPosition]
    }
}
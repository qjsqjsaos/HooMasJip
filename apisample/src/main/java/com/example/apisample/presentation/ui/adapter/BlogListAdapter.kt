package com.example.apisample.presentation.ui.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.apisample.R
import com.example.apisample.databinding.BlogItemBinding
import com.example.apisample.shared.BlogType
import com.example.apisample.shared.blog.Blog

class BlogListAdapter(private var list: List<Blog>) :
    RecyclerView.Adapter<BlogListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(
        BlogItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(position)

    override fun getItemCount(): Int = list.size

    inner class ViewHolder(private val binding: BlogItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(pos: Int) {
            val item = list[pos]
            item.let {
                Glide.with(binding.thumbnail.context)
                    .load(list[pos].thumbnail)
                    .error(R.drawable.naver_logo)
                    .into(binding.thumbnail)
                binding.title.text = it.title
                binding.contents.text = it.info
            }
            binding.executePendingBindings()
        }
    }

    fun updateList(list: List<Blog>) = diffNotify(list)

    private fun diffNotify(list: List<Blog>) {
        val diffResult = DiffUtil.calculateDiff(
            DiffUtilCallback(
                this@BlogListAdapter.list,
                list
            ), false
        )
        diffResult.dispatchUpdatesTo(this@BlogListAdapter)
        this@BlogListAdapter.list = list
    }
}
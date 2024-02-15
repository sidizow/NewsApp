package com.example.newsapp.utils.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.newsapp.R
import com.example.newsapp.databinding.ItemNewsBinding
import com.example.newsapp.domain.entities.NewsEntity

class NewsAdapter() : RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

    class NewsViewHolder(val binding: ItemNewsBinding) : RecyclerView.ViewHolder(binding.root)

    private var listNews: List<NewsEntity> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemNewsBinding.inflate(inflater, parent, false)
        return NewsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val news = listNews[position]
        with(holder.binding) {
            titleTextView.text = news.title
            dateTextView.text = news.publishedAt
            if (news.imageUrl.isNotBlank()) {
                Glide.with(imageView.context)
                    .load(news.imageUrl)
                    .placeholder(R.drawable.hide_image)
                    .error(R.drawable.hide_image)
                    .into(imageView)
            } else {
                imageView.setImageResource(R.drawable.hide_image)
            }
        }
    }

    override fun getItemCount(): Int = listNews.size

    fun renderNews(listNews: List<NewsEntity>) {
        val diffResult = DiffUtil.calculateDiff(NewsDiffCallback(this.listNews, listNews))
        this.listNews = listNews
        diffResult.dispatchUpdatesTo(this)
    }
}
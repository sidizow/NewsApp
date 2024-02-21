package com.example.newsapp.utils.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.newsapp.R
import com.example.newsapp.databinding.ItemHeaderBinding
import com.example.newsapp.databinding.ItemNewsBinding
import com.example.newsapp.domain.entities.DataItem

class NewsAdapter(
    private val actionListener: ActionListener,
) : RecyclerView.Adapter<ViewHolder>(), View.OnClickListener {


    private var listNews: List<DataItem> = emptyList()

    class NewsViewHolder(val binding: ItemNewsBinding) : ViewHolder(binding.root) {
        fun bind(newsEntity: DataItem.NewsEntity) {
            with(binding) {
                titleTextView.text = newsEntity.title
                dateTextView.text = newsEntity.publishedAt
                if (newsEntity.imageUrl.isNotBlank()) {
                    Glide.with(imageView.context)
                        .load(newsEntity.imageUrl)
                        .placeholder(R.drawable.ic_load)
                        .error(R.drawable.hide_image)
                        .into(imageView)
                } else {
                    imageView.setImageResource(R.drawable.hide_image)
                }
            }
        }
    }

    class HeaderViewHolder(val binding: ItemHeaderBinding) : ViewHolder(binding.root) {
        fun bind(header: DataItem.Header) {
            with(binding) {
                if (header.imageUrl.isNotBlank()) {
                    Glide.with(imageView.context)
                        .load(header.imageUrl)
                        .override(451, 200)
                        .placeholder(R.drawable.ic_load)
                        .error(R.drawable.hide_image)
                        .into(imageView)
                } else {
                    imageView.setImageResource(R.drawable.hide_image)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return when (viewType) {
            R.layout.item_news -> {
                val inflater = LayoutInflater.from(parent.context)
                val binding = ItemNewsBinding.inflate(inflater, parent, false)
                binding.root.setOnClickListener(this)
                NewsViewHolder(binding)
            }

            R.layout.item_header -> {
                val inflater = LayoutInflater.from(parent.context)
                val binding = ItemHeaderBinding.inflate(inflater, parent, false)
                HeaderViewHolder(binding)
            }

            else -> throw IllegalArgumentException("Invalid ViewType")
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        when (val items = listNews[position]) {
            is DataItem.NewsEntity -> {
                (holder as NewsViewHolder).bind(items)
                holder.itemView.tag = items
            }

            is DataItem.Header -> (holder as HeaderViewHolder).bind(items)
        }
    }


    override fun getItemCount(): Int = listNews.size

    fun renderNews(listNews: List<DataItem>) {
        val diffResult = DiffUtil.calculateDiff(NewsDiffCallback(this.listNews, listNews))
        this.listNews = listNews
        diffResult.dispatchUpdatesTo(this)
    }

    override fun onClick(v: View) {
        val news = v.tag as DataItem.NewsEntity
        val title = news.title
        val description = news.content
        val imageUrl = news.imageUrl
        val publishedAt = news.publishedAt
        val url = news.url
        actionListener.onOpenNewsPage(title, description, imageUrl, publishedAt, url)
    }

    override fun getItemViewType(position: Int): Int {
        return when (listNews[position]) {
            is DataItem.NewsEntity -> R.layout.item_news
            is DataItem.Header -> R.layout.item_header
            else -> throw IllegalArgumentException("Invalid DataItem")
        }
    }

    interface ActionListener {
        fun onOpenNewsPage(
            title: String,
            description: String,
            imageUrl: String,
            publishedAt: String,
            url: String,
        )
    }


}
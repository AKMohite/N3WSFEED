package com.ak.newsfeed.utils

import androidx.recyclerview.widget.DiffUtil
import com.ak.newsfeed.domain.model.NewsArticle

class DiffUtilNewsItemCallback: DiffUtil.ItemCallback<NewsArticle>() {
    override fun areItemsTheSame(oldItem: NewsArticle, newItem: NewsArticle): Boolean = oldItem.url == newItem.url

    override fun areContentsTheSame(oldItem: NewsArticle, newItem: NewsArticle): Boolean = oldItem == newItem
}
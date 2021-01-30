package com.ak.newsfeed.utils

import androidx.recyclerview.widget.DiffUtil
import com.ak.newsfeed.data.remote.Article

class DiffUtilNewsItemCallback: DiffUtil.ItemCallback<Article>() {
    override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean = oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean = oldItem == newItem
}
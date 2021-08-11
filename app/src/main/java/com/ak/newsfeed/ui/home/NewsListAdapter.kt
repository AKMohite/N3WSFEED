package com.ak.newsfeed.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.ak.newsfeed.databinding.ItemNewsImageBinding
import com.ak.newsfeed.domain.model.NewsArticle

class NewsListAdapter(diffCallback: DiffUtil.ItemCallback<NewsArticle>): ListAdapter<NewsArticle, ImageViewHolder>(diffCallback) {

//    TODO change click events
    private var listener: OnNewsItemClickEvent? = null



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {

        val layoutInflater = LayoutInflater.from(parent.context)
        val imageBinding = ItemNewsImageBinding.inflate(layoutInflater)
        return ImageViewHolder(imageBinding)
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holder.bindData(getItem(position))
    }

    fun setOnItemClickListener(listener: OnNewsItemClickEvent){
        this.listener = listener
    }

    public interface OnNewsItemClickEvent {
        fun onItemTextClick()
        fun onItemImageClick()
        fun onItemLongClick()
    }
}
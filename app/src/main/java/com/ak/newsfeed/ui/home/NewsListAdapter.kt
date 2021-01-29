package com.ak.newsfeed.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.ak.newsfeed.base.BaseViewHolder
import com.ak.newsfeed.data.remote.Article
import com.ak.newsfeed.databinding.ItemNewsImageBinding
import com.ak.newsfeed.databinding.ItemNewsTextBinding
import com.ak.newsfeed.utils.NewsType

class NewsListAdapter(private val diffCallback: DiffUtil.ItemCallback<Article>): ListAdapter<Article, BaseViewHolder>(diffCallback) {

//    TODO change click events
    private var listener: OnNewsItemClickEvent? = null



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {

        val layoutInflater = LayoutInflater.from(parent.context)
        return when(viewType){
            NewsType.TEXT_NEWS.viewType -> {
                val textBinding = ItemNewsTextBinding.inflate(layoutInflater)
                TextViewHolder(textBinding)
            }

            NewsType.IMAGE_NEWS.viewType -> {
                val imageBinding = ItemNewsImageBinding.inflate(layoutInflater)
                ImageViewHolder(imageBinding)
            }
            else -> {
                val defaultTextBinding = ItemNewsTextBinding.inflate(layoutInflater)
                TextViewHolder(defaultTextBinding)
            }
        }
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.bindData(getItem(position))
    }

    override fun getItemViewType(position: Int): Int {
        return getItem(position).viewType
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
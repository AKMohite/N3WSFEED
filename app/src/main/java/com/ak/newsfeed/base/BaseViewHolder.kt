package com.ak.newsfeed.base

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.ak.newsfeed.data.remote.Article
import com.ak.newsfeed.databinding.ItemNewsImageBinding
import com.ak.newsfeed.databinding.ItemNewsTextBinding

abstract class BaseViewHolder constructor(val itemView: View): RecyclerView.ViewHolder(itemView) {

    public abstract fun bindData(item: Article)

//    methods for shared view animation
    public abstract fun getItemNewsTextBinding(): ItemNewsTextBinding
    public abstract fun getItemNewsImageBinding(): ItemNewsImageBinding

}
package com.ak.newsfeed.ui.home

import coil.load
import com.ak.newsfeed.base.BaseViewHolder
import com.ak.newsfeed.data.remote.Article
import com.ak.newsfeed.databinding.ItemNewsImageBinding
import com.ak.newsfeed.databinding.ItemNewsTextBinding

class TextViewHolder constructor(binding: ItemNewsTextBinding): BaseViewHolder(binding.root) {
    private val bindingText: ItemNewsTextBinding
    init {
        bindingText = binding
    }
    override fun bindData(item: Article) {
        with(bindingText){
            itemNewsTextTitle.text = item.title
            itemNewsTextContent.text = item.content
            itemNewsTextUsername.text = item.author
            itemNewsTextUserimg.load(item.authorImage)
        }
    }

    override fun getItemNewsTextBinding(): ItemNewsTextBinding {
        TODO("Not yet implemented")
    }

    override fun getItemNewsImageBinding(): ItemNewsImageBinding {
        TODO("Not yet implemented")
    }
}
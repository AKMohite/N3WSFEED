package com.ak.newsfeed.ui.home

import coil.load
import com.ak.newsfeed.R
import com.ak.newsfeed.base.BaseViewHolder
import com.ak.newsfeed.data.remote.dto.Article
import com.ak.newsfeed.databinding.ItemNewsImageBinding
import com.ak.newsfeed.databinding.ItemNewsTextBinding
import com.ak.newsfeed.utils.BgColorType

class ImageViewHolder constructor(binding: ItemNewsImageBinding): BaseViewHolder(binding.root) {

    private val bindingImage: ItemNewsImageBinding

    init {
        bindingImage = binding
    }

    override fun bindData(item: Article) {
        with(bindingImage){
            itemNewsImgTitle.text = item.title
            itemNewsImgUsername.text = item.author
            itemNewsImgNewsimg.load(item.urlToImage)
            itemNewsImgUserimg.load(item.authorImage)
            when(item.bgColor){
                BgColorType.RED.color -> imageView2.setBackgroundColor(imageView2.context.resources.getColor(R.color.red))

                BgColorType.PURPLE.color -> imageView2.setBackgroundColor(imageView2.context.resources.getColor(R.color.purple))

                BgColorType.BLACK.color -> imageView2.setBackgroundColor(imageView2.context.resources.getColor(R.color.black))

                BgColorType.BLUE.color -> imageView2.setBackgroundColor(imageView2.context.resources.getColor(R.color.blue))

                BgColorType.YELLOW.color -> imageView2.setBackgroundColor(imageView2.context.resources.getColor(R.color.yellow))

                else -> imageView2.setBackgroundColor(imageView2.context.resources.getColor(R.color.red))
            }
        }
    }

    override fun getItemNewsTextBinding(): ItemNewsTextBinding {
        TODO("Not yet implemented")
    }

    override fun getItemNewsImageBinding(): ItemNewsImageBinding {
        TODO("Not yet implemented")
    }
}
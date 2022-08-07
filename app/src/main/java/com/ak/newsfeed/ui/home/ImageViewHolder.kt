package com.ak.newsfeed.ui.home

import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.size.Scale
import com.ak.newsfeed.R
import com.ak.newsfeed.databinding.ItemNewsImageBinding
import com.ak.newsfeed.domain.model.NewsArticle
import com.ak.newsfeed.utils.BgColorType

class ImageViewHolder constructor(binding: ItemNewsImageBinding): RecyclerView.ViewHolder(binding.root) {

    private val bindingImage: ItemNewsImageBinding

    init {
        bindingImage = binding
    }

    fun bindData(item: NewsArticle) {
        with(bindingImage){
            itemNewsImgTitle.text = item.title
            itemNewsImgUsername.text = item.author
            itemNewsImgNewsimg.load(item.newsImage) {
                error(R.mipmap.ic_launcher)
                placeholder(R.mipmap.ic_launcher)
                crossfade(750)
                scale(Scale.FILL)
            }
            itemNewsImgUserimg.load(item.url) {
                error(R.mipmap.ic_launcher)
                placeholder(R.mipmap.ic_launcher)
            }
            when(item.url){ // todo remove bg type
                BgColorType.RED.color -> imageView2.setBackgroundColor(imageView2.context.resources.getColor(R.color.red))

                BgColorType.PURPLE.color -> imageView2.setBackgroundColor(imageView2.context.resources.getColor(R.color.purple))

                BgColorType.BLACK.color -> imageView2.setBackgroundColor(imageView2.context.resources.getColor(R.color.black))

                BgColorType.BLUE.color -> imageView2.setBackgroundColor(imageView2.context.resources.getColor(R.color.blue))

                BgColorType.YELLOW.color -> imageView2.setBackgroundColor(imageView2.context.resources.getColor(R.color.yellow))

                else -> imageView2.setBackgroundColor(imageView2.context.resources.getColor(R.color.red))
            }
        }
    }
}
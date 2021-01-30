package com.ak.newsfeed.ui.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat

import com.ak.newsfeed.R
import com.ak.newsfeed.data.remote.Article
import com.ak.newsfeed.databinding.FragmentNewDetailBinding
import com.bumptech.glide.Glide

/**
 * A simple [Fragment] subclass.
 */
class NewsDetailFragment : Fragment(R.layout.fragment_new_detail) {

    private lateinit var binding: FragmentNewDetailBinding
    private var article: Article? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentNewDetailBinding.bind(view)

        binding.apply {
            Glide.with(requireContext()).load(article?.urlToImage).into(detailsImgNews)
            Glide.with(requireContext()).load(article?.authorImage).into(detailsImgUser)
            detailsTitle.text = article?.title
            detailsUsernameDate.text = article?.author
            detailsContent.text = article?.content
            if (article?.isFav == true){
                detailsImgFav.setColorFilter(ContextCompat.getColor(requireContext(), R.color.red))
            } else{
                detailsImgFav.setColorFilter(ContextCompat.getColor(requireContext(), R.color.darkIconTintColor))
            }

        }
    }

}

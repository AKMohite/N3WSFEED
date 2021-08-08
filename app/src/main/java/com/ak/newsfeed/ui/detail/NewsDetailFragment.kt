package com.ak.newsfeed.ui.detail

import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import coil.load
import com.ak.newsfeed.R
import com.ak.newsfeed.data.remote.dto.Article
import com.ak.newsfeed.databinding.FragmentNewDetailBinding

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
            detailsImgNews.load(article?.urlToImage)
            detailsImgUser.load(article?.authorImage)
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

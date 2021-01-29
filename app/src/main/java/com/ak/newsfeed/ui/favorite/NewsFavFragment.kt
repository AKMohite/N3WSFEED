package com.ak.newsfeed.ui.favorite

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.ak.newsfeed.R
import com.ak.newsfeed.databinding.FragmentNewsFavBinding

/**
 * A simple [Fragment] subclass.
 */
class NewsFavFragment : Fragment(R.layout.fragment_news_fav) {

    private lateinit var binding: FragmentNewsFavBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentNewsFavBinding.bind(view)
    }

}

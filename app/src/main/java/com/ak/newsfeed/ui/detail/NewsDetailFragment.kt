package com.ak.newsfeed.ui.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.ak.newsfeed.R
import com.ak.newsfeed.databinding.FragmentNewDetailBinding

/**
 * A simple [Fragment] subclass.
 */
class NewsDetailFragment : Fragment(R.layout.fragment_new_detail) {

    private lateinit var binding: FragmentNewDetailBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentNewDetailBinding.bind(view)
    }

}

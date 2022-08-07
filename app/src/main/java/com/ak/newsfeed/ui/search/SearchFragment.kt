package com.ak.newsfeed.ui.search

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.ak.newsfeed.R
import com.ak.newsfeed.databinding.FragmentSearchBinding
import com.ak.newsfeed.ui.home.NewsListAdapter
import com.ak.newsfeed.utils.DiffUtilNewsItemCallback

/**
 * A simple [Fragment] subclass.
 */
class SearchFragment : Fragment(R.layout.fragment_search) {

    private lateinit var binding: FragmentSearchBinding
    private var adapter: NewsListAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSearchBinding.bind(view)

        binding.apply {
            searchRv.setHasFixedSize(true)
            searchRv.layoutManager = GridLayoutManager(requireContext(), 2)
            adapter = NewsListAdapter(DiffUtilNewsItemCallback())
            searchRv.adapter = adapter
            adapter?.submitList(emptyList())
        }
    }

}

package com.ak.newsfeed.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager

import com.ak.newsfeed.R
import com.ak.newsfeed.databinding.FragmentNewsBinding
import com.ak.newsfeed.utils.DiffUtilNewsItemCallback
import com.ak.newsfeed.utils.FakeDataSource
import dagger.hilt.android.AndroidEntryPoint

/**
 * A simple [Fragment] subclass.
 */
@AndroidEntryPoint
class NewsFragment : Fragment(R.layout.fragment_news) {

    private val viewModel: HomeViewModel by viewModels()
    private lateinit var binding: FragmentNewsBinding
    private var adapter: NewsListAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentNewsBinding.bind(view)
        viewModel.getTopHeadlines()

        binding.apply {
            newsItemList.setHasFixedSize(true)
            newsItemList.layoutManager = GridLayoutManager(requireContext(), 2)
            adapter = NewsListAdapter(DiffUtilNewsItemCallback())
            newsItemList.adapter = adapter
            val fakeDataSource = FakeDataSource()
            adapter?.submitList(fakeDataSource.getFakeListNews())
            newsListSwipe.setOnRefreshListener {

            }
        }
    }

}

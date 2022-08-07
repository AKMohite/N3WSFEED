package com.ak.newsfeed.ui.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.ak.newsfeed.R
import com.ak.newsfeed.data.NewsResource
import com.ak.newsfeed.databinding.FragmentNewsBinding
import com.ak.newsfeed.domain.model.NewsArticle
import com.ak.newsfeed.utils.DiffUtilNewsItemCallback
import dagger.hilt.android.AndroidEntryPoint

/**
 * A simple [Fragment] subclass.
 */
@AndroidEntryPoint
class NewsFragment : Fragment(R.layout.fragment_news) {

    private val viewModel: HomeViewModel by viewModels()
    private lateinit var binding: FragmentNewsBinding
    private var newsAdapter: NewsListAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentNewsBinding.bind(view)

        binding.apply {
            newsItemList.layoutManager = LinearLayoutManager(requireContext())
            /*newsListSwipe.setOnRefreshListener {
                viewModel.getTopHeadlines()
            }*/
        }

        observeLiveData()
    }

    private fun observeLiveData() {
        viewModel.liveData.observe(viewLifecycleOwner) { dataWrapper ->
            when (dataWrapper) {
                is NewsResource.Error -> {}
                is NewsResource.Loading -> {}
                is NewsResource.Success -> populateData(dataWrapper.data!!)
            }
        }
    }

    private fun populateData(data: List<NewsArticle>) {
        newsAdapter = NewsListAdapter(DiffUtilNewsItemCallback())
        binding.newsItemList.adapter = newsAdapter
        newsAdapter?.submitList(data)
    }
}

package com.ak.newsfeed.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager

import com.ak.newsfeed.R
import com.ak.newsfeed.databinding.FragmentNewsBinding
import com.ak.newsfeed.utils.DiffUtilNewsItemCallback
import com.ak.newsfeed.utils.FakeDataSource

/**
 * A simple [Fragment] subclass.
 */
class NewsFragment : Fragment(R.layout.fragment_news) {

    private lateinit var binding: FragmentNewsBinding
    private var adapter: NewsListAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentNewsBinding.bind(view)

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

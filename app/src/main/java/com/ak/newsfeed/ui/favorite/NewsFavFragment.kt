package com.ak.newsfeed.ui.favorite

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager

import com.ak.newsfeed.R
import com.ak.newsfeed.databinding.FragmentNewsFavBinding
import com.ak.newsfeed.ui.home.NewsListAdapter
import com.ak.newsfeed.utils.DiffUtilNewsItemCallback
import com.ak.newsfeed.utils.FakeDataSource

/**
 * A simple [Fragment] subclass.
 */
class NewsFavFragment : Fragment(R.layout.fragment_news_fav) {

    private lateinit var binding: FragmentNewsFavBinding
    private var adapter: NewsListAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentNewsFavBinding.bind(view)

        binding.apply {
            rvFav.setHasFixedSize(true)
            rvFav.layoutManager = GridLayoutManager(requireContext(), 2)
            adapter = NewsListAdapter(DiffUtilNewsItemCallback())
            rvFav.adapter = adapter
            val fakeDataSource = FakeDataSource()
            adapter?.submitList(fakeDataSource.getFakeStaticListNews())
        }
    }

}

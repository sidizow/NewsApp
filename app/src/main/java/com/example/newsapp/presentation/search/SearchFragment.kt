package com.example.newsapp.presentation.search

import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newsapp.R
import com.example.newsapp.databinding.FragmentSearchBinding
import com.example.newsapp.presentation.TabsFragmentDirections
import com.example.newsapp.presentation.base.BaseFragment
import com.example.newsapp.utils.adapter.NewsAdapter
import com.example.newsapp.utils.findTopNavController
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchFragment : BaseFragment<FragmentSearchBinding>(
    R.layout.fragment_search,
    FragmentSearchBinding::inflate
) {

    override val viewModel by viewModels<SearchViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = setupNews()
        viewModel.searchNews.observe(viewLifecycleOwner) {
            adapter.renderNews(it)
        }

        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                viewModel.getSearchNews(query)
                binding.searchView.clearFocus()
                return true
            }

            override fun onQueryTextChange(newText: String): Boolean {
                return true
            }
        })

        openNewsPage()
    }

    private fun setupNews(): NewsAdapter {
        binding.searchNewsRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        val adapter = NewsAdapter(viewModel)
        binding.searchNewsRecyclerView.adapter = adapter
        return adapter
    }

    private fun openNewsPage(){
        viewModel.openNewsPageEvent.observe(viewLifecycleOwner){
            val newsArgs = it.get()
            if (newsArgs != null) {
                val direction =
                    TabsFragmentDirections.actionTabsFragmentToCurrentNewsFragment(newsArgs)
                findTopNavController().navigate(direction)
            }
        }
    }


}
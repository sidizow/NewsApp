package com.example.newsapp.presentation.sience

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newsapp.R
import com.example.newsapp.databinding.FragmentScienceNewsBinding
import com.example.newsapp.presentation.TabsFragmentDirections
import com.example.newsapp.presentation.base.BaseFragment
import com.example.newsapp.utils.adapter.NewsAdapter
import com.example.newsapp.utils.findTopNavController
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ScienceNewsFragment : BaseFragment<FragmentScienceNewsBinding>(
    R.layout.fragment_science_news,
    FragmentScienceNewsBinding::inflate
) {

    override val viewModel by viewModels<ScienceNewsViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = setupNews()
        viewModel.scienceNews.observe(viewLifecycleOwner) {
            adapter.renderNews(it)
        }
        openNewsPage()
    }

    private fun setupNews(): NewsAdapter {
        binding.scienceNewsRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        val adapter = NewsAdapter(viewModel)
        binding.scienceNewsRecyclerView.adapter = adapter
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
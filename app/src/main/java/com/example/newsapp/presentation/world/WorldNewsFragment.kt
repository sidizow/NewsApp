package com.example.newsapp.presentation.world

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newsapp.R
import com.example.newsapp.databinding.FragmentWorldNewsBinding
import com.example.newsapp.presentation.base.BaseFragment
import com.example.newsapp.utils.adapter.NewsAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WorldNewsFragment : BaseFragment<FragmentWorldNewsBinding>(
    R.layout.fragment_world_news,
    FragmentWorldNewsBinding::inflate
) {

    override val viewModel by viewModels<WorldNewsViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = setupNews()
        viewModel.worldNews.observe(viewLifecycleOwner) {
            adapter.renderNews(it)
        }
    }

    private fun setupNews(): NewsAdapter {
        binding.worldNewsRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        val adapter = NewsAdapter()
        binding.worldNewsRecyclerView.adapter = adapter
        return adapter
    }

}
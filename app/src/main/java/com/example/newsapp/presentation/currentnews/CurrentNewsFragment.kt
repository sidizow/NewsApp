package com.example.newsapp.presentation.currentnews

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.example.newsapp.R
import com.example.newsapp.databinding.FragmentCurrentNewsBinding
import com.example.newsapp.presentation.base.BaseFragment

class CurrentNewsFragment : BaseFragment<FragmentCurrentNewsBinding>(
    R.layout.fragment_current_news,
    FragmentCurrentNewsBinding::inflate
) {

    override val viewModel by viewModels<CurrentNewsViewModels>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.news.observe(viewLifecycleOwner){
            binding.titleTextView.text = it[0]
            binding.contentTextView.text = it[1]
            binding.dateTextView.text = it[3]
            binding.urlTextView.text = it[4]
            Glide.with(binding.imageView.context)
                .load(it[2])
                .placeholder(R.drawable.ic_load)
                .error(R.drawable.hide_image)
                .into(binding.imageView)
        }
    }





}
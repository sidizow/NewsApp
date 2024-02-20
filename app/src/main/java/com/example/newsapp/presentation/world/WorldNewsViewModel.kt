package com.example.newsapp.presentation.world

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsapp.domain.entities.NewsEntity
import com.example.newsapp.domain.world.usecases.GetWorldNewsUseCase
import com.example.newsapp.utils.MutableLiveEvent
import com.example.newsapp.utils.adapter.NewsAdapter
import com.example.newsapp.utils.publishEvent
import com.example.newsapp.utils.share
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class WorldNewsViewModel @Inject constructor(
    private val getWorldNewsUseCase: GetWorldNewsUseCase,
) : ViewModel(), NewsAdapter.ActionListener {

    private val _worldNews = MutableLiveData<List<NewsEntity>>()
    val worldNews = _worldNews.share()

    private val _openNewsPageEvent = MutableLiveEvent<Array<String>>()
    val openNewsPageEvent = _openNewsPageEvent.share()

    init {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                _worldNews.postValue(getWorldNewsUseCase.getWorldNews())
            }

        }
    }

    override fun onOpenNewsPage(
        title: String,
        description: String,
        imageUrl: String,
        publishedAt: String,
        url: String
    ) {
        _openNewsPageEvent.publishEvent(arrayOf(title, description, imageUrl, publishedAt, url))
    }

}
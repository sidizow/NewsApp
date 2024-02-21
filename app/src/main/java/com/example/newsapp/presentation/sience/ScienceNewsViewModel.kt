package com.example.newsapp.presentation.sience

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsapp.domain.entities.DataItem
import com.example.newsapp.domain.science.usecases.GetScienceNewsUseCase
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
class ScienceNewsViewModel @Inject constructor(
    private val getScienceNewsUseCase: GetScienceNewsUseCase,
) : ViewModel(), NewsAdapter.ActionListener {

    private val _scienceNews = MutableLiveData<List<DataItem>>()
    val scienceNews = _scienceNews.share()

    private val _openNewsPageEvent = MutableLiveEvent<Array<String>>()
    val openNewsPageEvent = _openNewsPageEvent.share()

    init {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                _scienceNews.postValue(getScienceNewsUseCase.getScienceNews())
            }

        }
    }

    override fun onOpenNewsPage(
        title: String,
        description: String,
        imageUrl: String,
        publishedAt: String,
        url: String,
    ) {
        _openNewsPageEvent.publishEvent(arrayOf(title, description, imageUrl, publishedAt, url))
    }
}
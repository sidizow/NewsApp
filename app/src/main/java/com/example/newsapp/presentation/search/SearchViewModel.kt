package com.example.newsapp.presentation.search

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsapp.domain.entities.NewsEntity
import com.example.newsapp.domain.search.usecases.GetSearchNewsUseCase
import com.example.newsapp.utils.share
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val getSearchNewsUseCase: GetSearchNewsUseCase
): ViewModel() {

    private val _searchNews = MutableLiveData<List<NewsEntity>>()
    val searchNews = _searchNews.share()

    init {
        viewModelScope.launch {
            withContext(Dispatchers.IO){
                _searchNews.postValue(getSearchNewsUseCase.getSearchNews("Animals"))
            }
        }
    }

    fun getSearchNews(query: String) = viewModelScope.launch{
        withContext(Dispatchers.IO){
            _searchNews.postValue(getSearchNewsUseCase.getSearchNews(query))
        }
    }



}
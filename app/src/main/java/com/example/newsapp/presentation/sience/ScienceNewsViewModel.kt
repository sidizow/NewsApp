package com.example.newsapp.presentation.sience

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsapp.domain.entities.NewsEntity
import com.example.newsapp.domain.science.usecases.GetScienceNewsUseCase
import com.example.newsapp.utils.share
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class ScienceNewsViewModel @Inject constructor(
    private val getScienceNewsUseCase: GetScienceNewsUseCase
): ViewModel() {

    private val _scienceNews = MutableLiveData<List<NewsEntity>>()
    val scienceNews = _scienceNews.share()

    init {
        viewModelScope.launch {
            withContext(Dispatchers.IO){
                _scienceNews.postValue(getScienceNewsUseCase.getScienceNews())
            }

        }
    }

}
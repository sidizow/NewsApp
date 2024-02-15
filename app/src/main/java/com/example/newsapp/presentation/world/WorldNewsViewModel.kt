package com.example.newsapp.presentation.world

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsapp.domain.entities.NewsEntity
import com.example.newsapp.domain.world.usecases.GetWorldNewsUseCase
import com.example.newsapp.utils.share
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class WorldNewsViewModel @Inject constructor(
    private val getWorldNewsUseCase: GetWorldNewsUseCase
): ViewModel() {

    private val _worldNews = MutableLiveData<List<NewsEntity>>()
    val worldNews = _worldNews.share()

    init {
        viewModelScope.launch {
            withContext(Dispatchers.IO){
                _worldNews.postValue(getWorldNewsUseCase.getWorldNews())
            }

        }
    }

}
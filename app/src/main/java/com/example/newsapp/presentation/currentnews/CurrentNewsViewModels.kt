package com.example.newsapp.presentation.currentnews

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.newsapp.utils.share
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CurrentNewsViewModels @Inject constructor(
    savedStateHandle: SavedStateHandle
): ViewModel() {

    private val navArgs = CurrentNewsFragmentArgs
        .fromSavedStateHandle(savedStateHandle)
    private val arrayCurrentNews = navArgs.title

    private val _news = MutableLiveData<Array<String>>()
    val news = _news.share()

    init {
        _news.value = arrayCurrentNews
    }



}
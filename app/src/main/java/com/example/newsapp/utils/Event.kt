package com.example.newsapp.utils

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class Event<T>(
    value: T
) {
    private var _value: T? = value
    fun get(): T? = _value.also { _value = null }

}

fun <T> MutableLiveData<T>.share(): LiveData<T> = this

typealias MutableLiveEvent<T> = MutableLiveData<Event<T>>


fun <T> MutableLiveEvent<T>.publishEvent(value: T) {
    this.value = Event(value)
}
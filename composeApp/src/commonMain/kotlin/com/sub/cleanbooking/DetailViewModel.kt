package com.sub.cleanbooking

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class DetailViewModel : ViewModel() {
    private val _countState = MutableStateFlow(0)
    val countState = _countState.asStateFlow()

    fun onAddCount() {
        _countState.update { it + 1 }
    }

    fun onClearCount() {
        _countState.update { 0 }
    }
}
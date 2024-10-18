package com.sub.cleanbooking

import androidx.lifecycle.ViewModel
import com.sub.cleanbooking.data.CountService
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class DetailViewModel(
    private val countService: CountService
) : ViewModel() {
    private val _countState = MutableStateFlow(0)
    val countState = _countState.asStateFlow()

    fun onAddCount() {
        val result = countService.getCount() + 1
        countService.saveCount(result)
        updateCount()
    }

    fun onClearCount() {
        countService.saveCount(0)
        updateCount()
    }

    private fun updateCount() {
        _countState.update { countService.getCount() }
    }
}
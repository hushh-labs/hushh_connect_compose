package com.example.hushh_connect_vone.Viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class CardViewModel : ViewModel() {
    private val _currentCardIndex = MutableStateFlow(0)
    val currentCardIndex: StateFlow<Int> = _currentCardIndex

    fun updateCardIndex(newIndex: Int) {
        _currentCardIndex.value = newIndex
    }
}

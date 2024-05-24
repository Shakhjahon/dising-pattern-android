package com.example.dising_pattern_android.facade

import androidx.lifecycle.ViewModel

class TestViewModel(
    private val startCarFacade: StartCarFacade
) : ViewModel() {
    init {
        startCarFacade.startCar()
    }
}
package com.cwong51799.api.randomfactapi

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class RandomFactViewModel : ViewModel() {
    private val _currentFact = MutableLiveData<String>()
        val currentFact : LiveData<String>
            get () = _currentFact

    fun changeCurrentFact(newFact : String) {
        _currentFact.value = newFact
    }

}
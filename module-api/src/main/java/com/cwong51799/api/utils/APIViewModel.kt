package com.cwong51799.api.utils

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class APIViewModel : ViewModel() {
    val selectedAPI = MutableLiveData<API>()

    fun select(api : API) {
        selectedAPI.value = api
    }

    fun resetSelected() {
        selectedAPI.value = null
    }
}
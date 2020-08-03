package com.cwong51799.api.api_selection

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.cwong51799.api.utils.API

class APISelectorViewModel : ViewModel() {
    val selectedAPI = MutableLiveData<API>()

    fun select(api : API) {
        selectedAPI.value = api
    }

    fun resetSelected() {
        selectedAPI.value = null
    }
}
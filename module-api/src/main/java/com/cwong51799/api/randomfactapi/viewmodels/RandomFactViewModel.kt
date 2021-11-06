package com.cwong51799.api.randomfactapi.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.cwong51799.api.randomfactapi.fragments.RandomFactFragment
import com.cwong51799.api.randomfactapi.network.FactResponse
import com.cwong51799.api.utils.APIUtils
import com.cwong51799.core.CoreExtensions.isNotNullOrEmpty
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RandomFactViewModel : ViewModel() {
    private val _currentFact = MutableLiveData<String>()
    val currentFact: LiveData<String>
        get() = _currentFact

    private val _errorMessage = MutableLiveData<String>()
    val errorMessage: LiveData<String> = _errorMessage

    fun getNewFact() {
        val call = APIUtils.RandomFactServices.getFact()
        call.enqueue(object : Callback<FactResponse> {
            override fun onFailure(call: Call<FactResponse>, t: Throwable) {
                _errorMessage.postValue(t.message)
            }

            override fun onResponse(call: Call<FactResponse>, response: Response<FactResponse>) {
                if (!response.isSuccessful) {
                    _currentFact.postValue("Code: " + response.code())
                } else {
                    response.body()?.text?.let {
                        changeCurrentFact(
                            it
                        )
                    }
                }
            }
        })
    }

    private fun changeCurrentFact(newFact: String) {
        _currentFact.value = newFact
    }

}
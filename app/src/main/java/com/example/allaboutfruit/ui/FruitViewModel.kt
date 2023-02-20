package com.example.allaboutfruit.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.allaboutfruit.data.model.FruitModel
import com.example.allaboutfruit.data.repository.Repository
import com.example.allaboutfruit.util.ResponseType
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FruitViewModel @Inject constructor(
   private val repository: Repository
): ViewModel() {

    private val _result = MutableLiveData<ResponseType<FruitModel>>()
    val result: LiveData<ResponseType<FruitModel>> = _result

    fun getAllFruit() {
        viewModelScope.launch {
            _result.postValue(ResponseType.Loading())
            val response = repository.getAllFruit()
            if (response.isSuccessful) {
                _result.postValue(ResponseType.Success(response.body()!!))
            } else {
                _result.postValue(ResponseType.Error(response.message()))
            }
        }
    }

    fun getFruitFamily() {
        viewModelScope.launch {
            _result.postValue(ResponseType.Loading())
            val response = repository.getFruitFamily()
            if (response.isSuccessful) {
                _result.postValue(ResponseType.Success(response.body()!!))
            } else {
                _result.postValue(ResponseType.Error(response.message()))
            }
        }
    }

    fun getFruitOrder() {
        viewModelScope.launch {
            _result.postValue(ResponseType.Loading())
            val response = repository.getFruitOrder()
            if (response.isSuccessful) {
                _result.postValue(ResponseType.Success(response.body()!!))
            } else {
                _result.postValue(ResponseType.Error(response.message()))
            }
        }
    }

    fun getFruitGenus() {
        viewModelScope.launch {
            _result.postValue(ResponseType.Loading())
            val response = repository.getFruitGenus()
            if (response.isSuccessful) {
                _result.postValue(ResponseType.Success(response.body()!!))
            } else {
                _result.postValue(ResponseType.Error(response.message()))
            }
        }
    }



}
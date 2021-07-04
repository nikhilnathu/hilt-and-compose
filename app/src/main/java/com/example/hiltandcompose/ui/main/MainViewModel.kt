package com.example.hiltandcompose.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: MainRepository) : ViewModel() {



    val stuff = repository.getString().asLiveData()

}



class MainRepository @Inject constructor() {
    private suspend fun getData() = listOf(1,2,3,4,5,6,7,8)

    fun getString() = flow {
        getData().forEach {
            emit(it)
            delay(1000)
        }
    }.flowOn(Dispatchers.IO)
}




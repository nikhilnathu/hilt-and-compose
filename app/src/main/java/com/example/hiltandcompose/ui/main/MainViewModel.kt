package com.example.hiltandcompose.ui.main

import androidx.lifecycle.*
import com.example.hiltandcompose.api.PokemonApi
import com.google.gson.JsonElement
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.flow.switchMap
import kotlinx.coroutines.launch
import retrofit2.awaitResponse
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: MainRepository) : ViewModel() {

    private val _pokemon = MutableLiveData<String>()
    val pokmon = _pokemon.switchMap { repository.getPokemon(it) }

    fun getPokemon(pokemon : String) {
        _pokemon.value = pokemon
    }



}



class MainRepository @Inject constructor(private val pokemonApi: PokemonApi) {
    private suspend fun getData() = listOf(1,2,3,4,5,6,7,8)

    fun getPokemon(pokemon : String) = liveData {
        val name = pokemonApi.getPokemon(pokemon).awaitResponse().body()?.name
        emit(name)
    }

}




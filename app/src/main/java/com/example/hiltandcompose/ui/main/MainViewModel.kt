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
    val pokemon = _pokemon.switchMap { getPokemonName(it) }

    fun getPokemon(pokemon: String) {
        _pokemon.value = pokemon
    }

    fun getPokemonName(name: String) = liveData {
        emit(repository.getPokemon(name)?.name)
    }
}


class MainRepository @Inject constructor(private val pokemonApi: PokemonApi) {
    suspend fun getPokemon(pokemon: String) = pokemonApi.getPokemon(pokemon).body()
}




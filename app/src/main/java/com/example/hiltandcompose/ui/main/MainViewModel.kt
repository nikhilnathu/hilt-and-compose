package com.example.hiltandcompose.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.switchMap
import com.example.hiltandcompose.api.PokemonApi
import dagger.hilt.android.lifecycle.HiltViewModel
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

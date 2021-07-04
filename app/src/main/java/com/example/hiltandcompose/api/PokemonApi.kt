package com.example.hiltandcompose.api

import androidx.lifecycle.LiveData
import com.example.hiltandcompose.data.Pokemon
import com.google.gson.JsonElement
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path


interface PokemonApi {

    @GET("pokemon/{pokemon}")
    fun getPokemon(
        @Path("pokemon") pokemon : String
    ) : Call<Pokemon>

}
package com.example.hiltandcompose.api

import com.example.hiltandcompose.data.Pokemon
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface PokemonApi {

    @GET("pokemon/{pokemon}")
    suspend fun getPokemon(
        @Path("pokemon") pokemon: String
    ): Response<Pokemon>
}

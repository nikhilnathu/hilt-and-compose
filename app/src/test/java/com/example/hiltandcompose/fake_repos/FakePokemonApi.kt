package com.example.hiltandcompose.fake_repos

import com.example.hiltandcompose.api.PokemonApi
import com.example.hiltandcompose.data.Pokemon
import retrofit2.Response

class FakePokemonApi : PokemonApi {
    override suspend fun getPokemon(pokemon: String): Response<Pokemon> {
        return Response.success(Pokemon(name = pokemon))
    }
}

package com.stevecampos.infrastructure.pokedex.repository.remote

import com.stevecampos.infrastructure.pokedex.entity.PokemonResponse
import retrofit2.Response
import retrofit2.http.GET

interface PokedexApiService {
    @GET("/pokedex")
    suspend fun getAllPokemons(): Response<List<PokemonResponse>>
}
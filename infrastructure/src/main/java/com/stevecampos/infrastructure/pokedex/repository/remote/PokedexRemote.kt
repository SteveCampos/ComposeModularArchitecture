package com.stevecampos.infrastructure.pokedex.repository.remote

import android.util.Log
import com.stevecampos.core.common.ErrorEntity
import com.stevecampos.core.common.Result
import com.stevecampos.domain.pokedex.entity.Pokemon
import com.stevecampos.domain.pokedex.repository.PokedexRepository
import com.stevecampos.infrastructure.pokedex.mapper.PokemonMapper

class PokedexRemote(
    private val apiService: PokedexApiService,
    private val pokemonMapper: PokemonMapper
) : PokedexRepository {

    companion object {
        const val TAG = "PokedexRemote"
    }

    override suspend fun getPokemons(): Result<List<Pokemon>> {

        val rawResponse = apiService.getAllPokemons()

        Log.d(TAG, "rawResponse: $rawResponse")
        if (!rawResponse.isSuccessful) {
            return Result.Error(ErrorEntity.ApiError.Network)
        }
        val rawBody = rawResponse.body()
        rawBody ?: return Result.Error(ErrorEntity.ApiError.Network)
        val data = rawBody.map {
            pokemonMapper.networkToDomain(it)
        }.toList()
        return Result.Success(data)
    }

}
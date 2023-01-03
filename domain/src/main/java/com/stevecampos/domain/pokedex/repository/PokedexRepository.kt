package com.stevecampos.domain.pokedex.repository

import com.stevecampos.domain.pokedex.entity.Pokemon

interface PokedexRepository {
    suspend fun getPokemons(): com.stevecampos.core.common.Result<List<Pokemon>>
}
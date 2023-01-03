package com.stevecampos.domain.repository

import com.stevecampos.domain.entity.Pokemon

interface PokemonRepository {
    suspend fun getPokemons(): com.stevecampos.core.common.Result<List<Pokemon>>
}
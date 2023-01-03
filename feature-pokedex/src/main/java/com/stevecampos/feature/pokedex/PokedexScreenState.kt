package com.stevecampos.feature.pokedex

import com.stevecampos.domain.pokedex.entity.Pokemon

sealed class PokedexScreenState {
    object Loading : PokedexScreenState()
    data class Success(val pokemons: List<Pokemon>) : PokedexScreenState()
    data class Error(val tryAgain: () -> Unit) : PokedexScreenState()
}
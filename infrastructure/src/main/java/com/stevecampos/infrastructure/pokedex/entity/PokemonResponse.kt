package com.stevecampos.infrastructure.pokedex.entity

data class PokemonResponse(
    val number: Int,
    val name: String,
    val types: List<String>,
    val image: String
)

package com.stevecampos.domain.pokedex.entity

data class Pokemon(
    val number: Int,
    val name: String,
    val types: List<PokemonType>,
    val image: String,
)

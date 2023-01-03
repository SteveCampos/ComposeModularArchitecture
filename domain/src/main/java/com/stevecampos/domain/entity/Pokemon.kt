package com.stevecampos.domain.entity

data class Pokemon(
    val number: Int,
    val name: String,
    val types: List<PokemonType>,
    val image: String,
)

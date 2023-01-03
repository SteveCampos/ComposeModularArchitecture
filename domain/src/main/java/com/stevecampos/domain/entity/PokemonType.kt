package com.stevecampos.domain.entity

sealed class PokemonType {
    object Grass: PokemonType()
    object Poison: PokemonType()
    object Fire: PokemonType()
    object Flying: PokemonType()
    object Water: PokemonType()
    object Electric: PokemonType()
}

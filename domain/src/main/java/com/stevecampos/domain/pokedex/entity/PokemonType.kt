package com.stevecampos.domain.pokedex.entity

sealed class PokemonType {
    object Grass: PokemonType()
    object Poison: PokemonType()
    object Fire: PokemonType()
    object Flying: PokemonType()
    object Water: PokemonType()
    object Electric: PokemonType()
}

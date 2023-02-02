package com.stevecampos.infrastructure.pokedex.mapper

import com.stevecampos.domain.pokedex.entity.Pokemon
import com.stevecampos.domain.pokedex.entity.PokemonType
import com.stevecampos.infrastructure.pokedex.entity.PokemonResponse

class PokemonMapper {

    fun networkToDomain(pokemonNetworkResponse: PokemonResponse): Pokemon {
        return Pokemon(
            number = pokemonNetworkResponse.number,
            name = pokemonNetworkResponse.name,
            types = fromStringListToPokemonTypeList(pokemonNetworkResponse.types),
            image = pokemonNetworkResponse.image
        )
    }

    fun fromStringListToPokemonTypeList(items: List<String>) = items.map { stringToPokemonType(it) }

    private fun stringToPokemonType(pokemonTypeName: String): PokemonType {
        return when (pokemonTypeName.trim().lowercase()) {
            "grass" -> PokemonType.Grass
            "electric" -> PokemonType.Electric
            "fire" -> PokemonType.Fire
            "water" -> PokemonType.Water
            "poison" -> PokemonType.Poison
            "flying" -> PokemonType.Flying
            else -> PokemonType.Unknown
        }
    }
}
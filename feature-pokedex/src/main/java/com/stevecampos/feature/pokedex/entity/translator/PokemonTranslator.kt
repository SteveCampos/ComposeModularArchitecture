package com.stevecampos.feature.pokedex.entity.translator

import androidx.annotation.DrawableRes
import com.stevecampos.domain.pokedex.entity.Pokemon
import com.stevecampos.domain.pokedex.entity.PokemonType
import com.stevecampos.feature.pokedex.R
import com.stevecampos.feature.pokedex.entity.PokemonUi

class PokemonTranslator {

    fun domainToUi(pokemon: Pokemon): PokemonUi {
        return PokemonUi(
            number = pokemon.number,
            name = pokemon.name,
            pokemonTypes = pokemon.types,
            pokemonDrawableResourceId = obtainDrawableResourceIdFromPokemon(pokemon),
            backgroundColorValue = obtainBackgroundColorFromPokemon(pokemon)
        )
    }

    private fun obtainBackgroundColorFromPokemon(pokemon: Pokemon): Long {
        return when (pokemon.types.first()) {
            is PokemonType.Grass -> 0xFF48D0B0
            is PokemonType.Fire -> 0xFFFB6C6C
            is PokemonType.Water -> 0xFF77BDFE
            is PokemonType.Electric -> 0xFFFFCE4B
            else -> 0xFFFFCE4B
        }
    }
}

@DrawableRes
private fun
        obtainDrawableResourceIdFromPokemon(pokemon: Pokemon): Int {
    return when (pokemon.image) {
        "/bulbasaur" -> R.drawable.bulbasaur_3x
        "/ivysaur" -> R.drawable.ivysaur_3x
        "/venusaur" -> R.drawable.venusaur_3x
        "/charmander" -> R.drawable.charmander_3x
        "/charmeleon" -> R.drawable.charmeleon_3x
        "/charizard" -> R.drawable.charizard_3x
        "/squirtle" -> R.drawable.squirtle_3x
        "/wartortle" -> R.drawable.wartortle_3x
        "/blastoise" -> R.drawable.blastoise_3x
        "/pikachu" -> R.drawable.pikachu_3x
        else -> R.drawable.pokeball
    }
}
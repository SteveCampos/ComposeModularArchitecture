package com.stevecampos.feature.pokedex.component

import androidx.annotation.DrawableRes
import com.stevecampos.domain.pokedex.entity.Pokemon
import com.stevecampos.feature.pokedex.R

class PokemonNameToDrawableTranslator {

    @DrawableRes
    fun obtainDrawableResourceIdFromPokemon(pokemon: Pokemon): Int {
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
}
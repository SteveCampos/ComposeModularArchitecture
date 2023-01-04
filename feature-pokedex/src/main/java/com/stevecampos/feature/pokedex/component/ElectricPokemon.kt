package com.stevecampos.feature.pokedex.component

import androidx.compose.foundation.background
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.stevecampos.domain.pokedex.entity.Pokemon

@Composable
fun ElectricPokemon(
    pokemon: Pokemon,
    pokemonNameToDrawableTranslator: PokemonNameToDrawableTranslator,
    modifier: Modifier = Modifier
) {
    PokemonCard(
        pokemonNumber = pokemon.number,
        pokemonName = pokemon.name,
        pokemonTypes = pokemon.types,
        pokemonDrawableResourceId = pokemonNameToDrawableTranslator.obtainDrawableResourceIdFromPokemon(
            pokemon
        ),
        modifier = modifier
            .background(
                color = Color(0xFFFFCE4B)
            )
    )
}
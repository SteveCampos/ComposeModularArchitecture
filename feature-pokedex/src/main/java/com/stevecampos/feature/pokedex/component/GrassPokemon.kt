package com.stevecampos.feature.pokedex.component

import androidx.compose.foundation.background
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.stevecampos.domain.pokedex.entity.Pokemon

@Composable
fun GrassPokemon(
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
                color = Color(0xFF48D0B0)
            )
            /*.background(
                brush = Brush.verticalGradient(
                    listOf(
                        Color(70, 165, 135),
                        Color(70, 215, 171),
                    )
                )
            )*/
    )
}
package com.stevecampos.feature.pokedex.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.stevecampos.domain.pokedex.entity.Pokemon
import com.stevecampos.domain.pokedex.entity.PokemonType

@Composable
fun PokedexGrid(pokemons: List<Pokemon>, modifier: Modifier = Modifier) {
    val pokemonNameToDrawableTranslator = remember {
        PokemonNameToDrawableTranslator()
    }
    LazyVerticalGrid(
        columns = GridCells.Adaptive(172.dp),
        modifier = modifier,
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
    ) {

        header {
            Text(
                text = "Pokedex",
                style = MaterialTheme.typography.h5.copy(
                    fontWeight =
                    FontWeight.ExtraBold
                )
            )
        }
        items(pokemons.size) { index ->

            val pokemon = pokemons[index]
            return@items when (pokemon.types.first()) {
                is PokemonType.Grass -> GrassPokemon(
                    pokemon = pokemon,
                    pokemonNameToDrawableTranslator = pokemonNameToDrawableTranslator,
                )
                is PokemonType.Fire ->
                    FirePokemon(
                        pokemon = pokemon,
                        pokemonNameToDrawableTranslator = pokemonNameToDrawableTranslator,
                    )
                is PokemonType.Water ->
                    WaterPokemon(
                        pokemon = pokemon,
                        pokemonNameToDrawableTranslator = pokemonNameToDrawableTranslator,
                    )
                is PokemonType.Electric ->
                    ElectricPokemon(
                        pokemon = pokemon,
                        pokemonNameToDrawableTranslator = pokemonNameToDrawableTranslator,
                    )
                else -> GrassPokemon(
                    pokemon = pokemon,
                    pokemonNameToDrawableTranslator = pokemonNameToDrawableTranslator,
                )
            }
        }
    }
}

fun LazyGridScope.header(
    content: @Composable LazyGridItemScope.() -> Unit
) {
    item(span = { GridItemSpan(this.maxLineSpan) }, content = content)
}
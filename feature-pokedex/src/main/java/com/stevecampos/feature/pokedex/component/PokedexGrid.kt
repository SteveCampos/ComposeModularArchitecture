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
import com.stevecampos.feature.pokedex.entity.translator.PokemonTranslator


@Composable
fun PokedexGrid(pokemons: List<Pokemon>, modifier: Modifier = Modifier) {
    val pokemonTranslator = remember {
        PokemonTranslator()
    }
    LazyVerticalGrid(
        columns = GridCells.Adaptive(144.dp),
        //columns = GridCells.Fixed(2),
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
            val pokemonUi = pokemonTranslator.domainToUi(pokemon)
            PokemonCard(
                pokemonUi = pokemonUi
            )
        }
    }
}

fun LazyGridScope.header(
    content: @Composable LazyGridItemScope.() -> Unit
) {
    item(span = { GridItemSpan(this.maxLineSpan) }, content = content)
}
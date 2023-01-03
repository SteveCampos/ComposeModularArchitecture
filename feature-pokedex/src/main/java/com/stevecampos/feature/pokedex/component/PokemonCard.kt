package com.stevecampos.feature.pokedex.component

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.stevecampos.domain.entity.Pokemon

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PokemonCard(pokemon: Pokemon) {
    ListItem(
        headlineText = { Text("Name: ${pokemon.name}") },
        overlineText = { Text("Number: ${pokemon.number}") },
        supportingText = { Text("Types: ${pokemon.types.joinToString()}") },
    )
}
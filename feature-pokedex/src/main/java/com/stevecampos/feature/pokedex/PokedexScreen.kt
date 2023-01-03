package com.stevecampos.feature.pokedex

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.stevecampos.domain.entity.Pokemon
import com.stevecampos.feature.pokedex.component.PokemonCard

@Composable
fun PokedexScreen(
    pokedexViewModel: PokedexViewModel = hiltViewModel()
) {
    val screenState = pokedexViewModel.pokedexScreenState.collectAsState().value


    when (screenState) {

        is PokedexScreenState.Loading -> PokedexLoading(Modifier)
        is PokedexScreenState.Error -> PokedexError(Modifier, screenState.tryAgain)
        is PokedexScreenState.Success -> PokedexSuccess(Modifier, screenState.pokemons)
    }
}

@Composable
fun PokedexSuccess(modifier: Modifier, pokemons: List<Pokemon>) {
    LazyColumn(modifier) {
        items(pokemons) {
            PokemonCard(it)
        }
    }
}


@Composable
fun PokedexError(modifier: Modifier, tryAgain: () -> Unit) {
    Column() {
        Text("PokedexErrorScreen")
        Button(onClick = { tryAgain() }) {
            Text(text = "Try Again")
        }
    }
}

@Composable
fun PokedexLoading(modifier: Modifier) {
    CircularProgressIndicator(modifier)
}

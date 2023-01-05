package com.stevecampos.feature.pokedex

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.List
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import com.stevecampos.domain.pokedex.entity.Pokemon
import com.stevecampos.feature.pokedex.component.PokedexGrid

@Composable
fun PokedexRoute(
    pokedexViewModel: PokedexViewModel = hiltViewModel()
) {
    val screenState = pokedexViewModel.pokedexScreenState.collectAsState().value
    PokedexScreen(screenState = screenState)
}

@Composable
fun PokedexScreen(
    screenState: PokedexScreenState
) {
    when (screenState) {
        is PokedexScreenState.Loading -> PokedexLoading(Modifier)
        is PokedexScreenState.Error -> PokedexError(screenState.tryAgain)
        is PokedexScreenState.Success -> PokedexSuccess(screenState.pokemons)
    }
}

@Composable
fun PokedexSuccess(pokemons: List<Pokemon>, modifier: Modifier = Modifier) {

    Scaffold(topBar = {
        TopAppBar(title = {
            Spacer(modifier = Modifier.fillMaxSize())
        }, navigationIcon = {
            IconButton(onClick = {}) {
                Icon(
                    Icons.Filled.ArrowBack, tint = Color.Black, contentDescription = "backIcon"
                )
            }
        }, backgroundColor = Color.White, actions = {
            IconButton(onClick = {/* Do Something*/ }) {
                Icon(Icons.Filled.List, contentDescription = null, tint = Color.Black)
            }
        })
    }, content = {
        PokedexGrid(pokemons = pokemons, modifier = modifier.padding(it))
    })

}


@Composable
fun PokedexError(tryAgain: () -> Unit, modifier: Modifier = Modifier) {
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

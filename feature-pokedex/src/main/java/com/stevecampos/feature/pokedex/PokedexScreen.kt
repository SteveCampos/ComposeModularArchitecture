package com.stevecampos.feature.pokedex

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.List
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
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
        when (screenState) {
            is PokedexScreenState.Loading -> PokedexLoading(modifier = Modifier.padding(it))
            is PokedexScreenState.Error -> PokedexError(
                screenState.tryAgain,
                modifier = Modifier.padding(it)
            )
            is PokedexScreenState.Success -> PokedexSuccess(
                screenState.pokemons,
                modifier = Modifier.padding(it)
            )
        }
    })
}

@Composable
fun PokedexSuccess(pokemons: List<Pokemon>, modifier: Modifier = Modifier) {
    PokedexGrid(pokemons = pokemons, modifier)
}


@Composable
fun PokedexError(tryAgain: () -> Unit, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .semantics {
                contentDescription = "Error "
            },
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painterResource(R.drawable.meowth),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(.4f)
        )
        Text(stringResource(id = R.string.msg_error_generic))
        TextButton(onClick = { tryAgain() }) {
            Text(stringResource(id = R.string.msg_try_again))
        }
    }
}

@Composable
fun PokedexLoading(modifier: Modifier) {
    Box(modifier = modifier
        .fillMaxSize()
        .semantics { contentDescription = "Loading Indicator" }
    ) {
        CircularProgressIndicator(Modifier.align(Alignment.Center))
    }
}

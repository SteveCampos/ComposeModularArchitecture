package com.stevecampos.modulararchitecture

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.stevecampos.feature.pokedex.navigation.pokedexScreen

@Composable
fun NavigationComponent(
    navHostController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navHostController,
        startDestination = "/pokedex",
        modifier = modifier
    ) {
        pokedexScreen()
    }
}
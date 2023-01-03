package com.stevecampos.feature.pokedex.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.stevecampos.feature.pokedex.PokedexScreen

class PokedexRoute {
    companion object {
        const val route = "/pokedex"
    }
}


fun NavGraphBuilder.pokedexRoute(){
    composable(PokedexRoute.route){
        PokedexScreen()
    }
}

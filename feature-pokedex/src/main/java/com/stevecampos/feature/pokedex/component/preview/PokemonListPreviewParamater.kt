package com.stevecampos.feature.pokedex.component.preview

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.stevecampos.domain.pokedex.entity.Pokemon
import com.stevecampos.domain.pokedex.entity.PokemonType

class PokemonListPreviewParamater : PreviewParameterProvider<List<Pokemon>> {
    override val values: Sequence<List<Pokemon>>
        get() = sequenceOf(
            listOf(
                Pokemon(
                    1,
                    "Bulbasaur",
                    listOf(PokemonType.Grass, PokemonType.Poison),
                    "/bulbasaur"
                ),
                Pokemon(2, "Ivysaur", listOf(PokemonType.Grass, PokemonType.Poison), "/ivysaur"),
                Pokemon(3, "Venusaur", listOf(PokemonType.Grass, PokemonType.Poison), "/venusaur"),
                Pokemon(4, "Charmander", listOf(PokemonType.Fire), "/charmander"),
                Pokemon(5, "Charmeleon", listOf(PokemonType.Fire), "/charmeleon"),
                Pokemon(6, "Charizard", listOf(PokemonType.Fire, PokemonType.Flying), "/charizard"),
                Pokemon(7, "Squirtle", listOf(PokemonType.Water), "/squirtle"),
                Pokemon(8, "Wartortle", listOf(PokemonType.Water), "/wartortle"),
                Pokemon(9, "Blastoise", listOf(PokemonType.Water), "/blastoise"),
                Pokemon(10, "Pikachu", listOf(PokemonType.Electric), "/pikachu"),
            )
        )

}
package com.stevecampos.feature.pokedex.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.clearAndSetSemantics
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.stevecampos.feature.pokedex.R
import com.stevecampos.feature.pokedex.entity.PokemonUi


@Composable
fun PokemonCard(
    pokemonUi: PokemonUi,
    modifier: Modifier = Modifier
) {

    Card(
        shape = RoundedCornerShape(24.dp),
        contentColor = Color.White,
        elevation = 10.dp,
        modifier = Modifier
            .clearAndSetSemantics {
                contentDescription = pokemonUi.getContentDescription()
            },
        backgroundColor = Color(pokemonUi.backgroundColorValue)
    ) {
        Box(
            modifier = Modifier
                .clickable { }
                .fillMaxWidth()
                .then(modifier)
                .aspectRatio(1.4f)
        ) {
            PokeballImage(Modifier.align(Alignment.BottomEnd))
            PokemonImage(pokemonUi.pokemonDrawableResourceId, Modifier.align(Alignment.BottomEnd))
            Text(
                text = pokemonUi.getNumberFormatted(),
                color = Color.Black.copy(.2f),
                modifier = Modifier
                    .padding(top = 8.dp, end = 16.dp)
                    .align(Alignment.TopEnd),
                fontWeight = FontWeight.Bold
            )
            Column(
                modifier = Modifier
                    .align(Alignment.CenterStart)
                    .padding(start = 24.dp, top = 24.dp, bottom = 24.dp)
            ) {
                Text(
                    pokemonUi.name,
                    style = MaterialTheme.typography.body1,
                    fontWeight = FontWeight.ExtraBold
                )
                Spacer(modifier = Modifier.padding(4.dp))
                pokemonUi.pokemonTypes.map { pokemonType ->
                    PowerChip(pokemonType.javaClass.simpleName)
                    Spacer(modifier = Modifier.padding(2.dp))
                }
            }
        }
    }
}

@Composable
fun PowerChip(text: String, modifier: Modifier = Modifier) {
    Text(
        text,
        color = Color.White,
        style = MaterialTheme.typography.overline,
        modifier = modifier
            .background(
                color = Color.White.copy(alpha = .15f),
                shape = RoundedCornerShape(8.dp)
            )
            .padding(horizontal = 12.dp, vertical = 4.dp),
    )
}


@Composable
fun PokemonImage(
    @DrawableRes drawableResourceId: Int, modifier: Modifier = Modifier
) {
    Image(
        painter = painterResource(drawableResourceId),
        contentDescription = "Bulbasaur",
        modifier = modifier.fillMaxWidth(.5f)
    )
}

@Composable
fun PokeballImage(modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(R.drawable.pokeball),
        contentDescription = "Pokeball Shadow",
        modifier = modifier.size(width = 88.dp, height = 76.dp),
        //colorFilter = ColorFilter.tint(color = Color.White)
    )
}

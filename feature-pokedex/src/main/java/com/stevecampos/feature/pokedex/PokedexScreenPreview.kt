package com.stevecampos.feature.pokedex

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import com.stevecampos.feature.pokedex.preview.SuccessStateProvider

@Preview(device = Devices.NEXUS_5, name = "SMALL_PHONE")
@Preview(device = Devices.PHONE, name = "PHONE")
@Preview(device = Devices.TABLET, name = "TABLET")
@Composable
fun PokedexScreen(
    @PreviewParameter(
        SuccessStateProvider::class,
        1
    ) state: PokedexScreenState.Success
) {
    PokedexScreen(screenState = state)
}

@Preview(device = Devices.NEXUS_5, name = "SMALL_PHONE")
@Preview(device = Devices.PHONE, name = "PHONE")
@Preview(device = Devices.TABLET, name = "TABLET")
@Composable
fun PokedexScreenError() {
    PokedexScreen(screenState = PokedexScreenState.Error({}))
}

@Preview(device = Devices.NEXUS_5, name = "SMALL_PHONE")
@Preview(device = Devices.PHONE, name = "PHONE")
@Preview(device = Devices.TABLET, name = "TABLET")
@Composable
fun PokedexScreenLoading() {
    PokedexScreen(screenState = PokedexScreenState.Loading)
}


package com.stevecampos.feature.pokedex

import androidx.compose.ui.semantics.ProgressBarRangeInfo
import androidx.compose.ui.semantics.SemanticsProperties
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import com.stevecampos.domain.pokedex.entity.Pokemon
import com.stevecampos.domain.pokedex.entity.PokemonType
import org.junit.Rule
import org.junit.Test

class PokedexScreenTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun whenLoadingState_shouldProgressBeDisplayed() {
        //Arrange

        val progressIndeterminateMatcher = SemanticsMatcher.expectValue(
            SemanticsProperties.ProgressBarRangeInfo, ProgressBarRangeInfo.Indeterminate
        )
        //Act
        composeTestRule.setContent {
            PokedexScreen(screenState = PokedexScreenState.Loading)
        }

        //Assert
        composeTestRule.onNode(progressIndeterminateMatcher).assertIsDisplayed()
    }

    @Test
    fun whenSuccessState_shouldPokedexContentBeDisplayed() {
        //Arrange

        val successState = PokedexScreenState.Success(
            listOf(
                Pokemon(1, "Bulbasaur", listOf(PokemonType.Grass, PokemonType.Poison), "/bulbasaur")
            )
        )
        // Act
        composeTestRule.setContent {
            PokedexScreen(screenState = successState)
        }

        composeTestRule.onRoot().printToLog("PokedexScreenTest")
        // Assert

        composeTestRule.onNode(hasText("Pokedex")).assertIsDisplayed()

        composeTestRule.onNodeWithContentDescription("#001, Bulbasaur, Grass, Poison", useUnmergedTree = true)
            .assertIsDisplayed()
    }
}
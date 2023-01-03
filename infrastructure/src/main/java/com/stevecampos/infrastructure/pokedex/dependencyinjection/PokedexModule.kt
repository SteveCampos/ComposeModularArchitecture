package com.stevecampos.infrastructure.pokedex.dependencyinjection

import com.stevecampos.domain.pokedex.repository.PokedexRepository
import com.stevecampos.domain.pokedex.usecase.GetPokemonsUseCase
import com.stevecampos.infrastructure.pokedex.repository.PokedexRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class PokedexModule {


    @Provides
    @Singleton
    fun providePokedexRepository(): PokedexRepository = PokedexRepositoryImpl()

    @Provides
    @Singleton
    fun provideGetPokemonUseCase(pokedexRepository: PokedexRepository): GetPokemonsUseCase =
        GetPokemonsUseCase(pokedexRepository)
}
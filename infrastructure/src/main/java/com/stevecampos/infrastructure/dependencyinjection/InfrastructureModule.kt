package com.stevecampos.infrastructure.dependencyinjection

import com.stevecampos.domain.repository.PokemonRepository
import com.stevecampos.domain.usecase.GetPokemonsUseCase
import com.stevecampos.infrastructure.PokemonRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class InfrastructureModule {


    @Provides
    @Singleton
    fun providePokemonRepository(): PokemonRepository = PokemonRepositoryImpl()

    @Provides
    @Singleton
    fun provideGetPokemonUseCase(pokemonRepository: PokemonRepository): GetPokemonsUseCase =
        GetPokemonsUseCase(pokemonRepository)
}
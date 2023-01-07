package com.stevecampos.core.common.dependencyinjection

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

@Module
@InstallIn(SingletonComponent::class)
object TestsDispatchersModule {
    @Provides
    fun provideIoDispatcher(): CoroutineDispatcher = Dispatchers.IO
}
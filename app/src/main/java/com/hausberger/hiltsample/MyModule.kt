package com.hausberger.hiltsample

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
abstract class MyModule {

    @Singleton
    @Binds
    abstract fun bindSomeDependency(
        someImpl: SomeInterfaceImpl
    ): SomeInterface
}
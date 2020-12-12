package com.hausberger.hiltsample

import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Qualifier
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
class MyModule {

    @ImplA
    @Singleton
    @Provides
    fun provideSomeInterfaceA(): SomeInterface {
        return SomeInterfaceImplA()
    }

    @ImplB
    @Singleton
    @Provides
    fun provideSomeInterfaceB(): SomeInterface {
        return SomeInterfaceImplB()
    }

    @Singleton
    @Provides
    fun provideGson(): Gson {
        return Gson()
    }
}

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class ImplA

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class ImplB
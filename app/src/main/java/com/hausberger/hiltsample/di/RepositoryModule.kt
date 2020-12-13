package com.hausberger.hiltsample.di

import com.hausberger.hiltsample.repository.MainRepository
import com.hausberger.hiltsample.retrofit.BlogRetrofit
import com.hausberger.hiltsample.retrofit.NetworkMapper
import com.hausberger.hiltsample.room.BlogDao
import com.hausberger.hiltsample.room.CacheMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideMainRepository(
        blogDao: BlogDao,
        retrofit: BlogRetrofit,
        cacheMapper: CacheMapper,
        networkMapper: NetworkMapper
    ): MainRepository {
        return MainRepository(
            blogDao = blogDao,
            blogRetrofit = retrofit,
            cacheMapper = cacheMapper,
            networkMapper = networkMapper
        )
    }
}
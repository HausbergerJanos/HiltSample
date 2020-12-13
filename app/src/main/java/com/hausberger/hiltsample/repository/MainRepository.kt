package com.hausberger.hiltsample.repository

import com.hausberger.hiltsample.model.Blog
import com.hausberger.hiltsample.retrofit.BlogRetrofit
import com.hausberger.hiltsample.retrofit.NetworkMapper
import com.hausberger.hiltsample.room.BlogDao
import com.hausberger.hiltsample.room.CacheMapper
import com.hausberger.hiltsample.util.DataState
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.lang.Exception

class MainRepository
constructor(
    private val blogDao: BlogDao,
    private val blogRetrofit: BlogRetrofit,
    private val cacheMapper: CacheMapper,
    private val networkMapper: NetworkMapper
) {

    suspend fun getBlog(): Flow<DataState<List<Blog>>> = flow {
        emit(DataState.Loading)

        delay(1000)

        try {
            val networkBlog = blogRetrofit.getAll()
            val blogs = networkMapper.mapFromEntityList(networkBlog)
            blogs.forEach {
                blogDao.insert(cacheMapper.mapToEntity(it))
            }

            val cachedBlogs = blogDao.getAll()
            emit(DataState.Success(cacheMapper.mapFromEntityList(cachedBlogs)))
        } catch (e: Exception) {
            emit(DataState.Error(e))
        }
    }
}

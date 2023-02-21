package com.wonjong.eventdispatcher.data.repositoryImpl

import com.wonjong.eventdispatcher.domain.repository.PostRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.github.captainwonjong.remote.api.PostService
import javax.inject.Singleton

/**
 * Created by CaptainWonJong@gmail.com on 2023-01-03
 */
@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun bindPost(postService: PostService): PostRepository = PostRepositoryImpl(postService)
}
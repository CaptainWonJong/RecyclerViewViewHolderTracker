package io.github.captainwonjong.repositoryImpl

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.github.captainwonjong.repository.post.PostRepository
import io.github.captainwonjong.repositoryImpl.post.PostRepositoryImpl

/**
 * Created by CaptainWonJong@gmail.com on 2023-01-03
 */
@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindPost(impl: PostRepositoryImpl): PostRepository
}
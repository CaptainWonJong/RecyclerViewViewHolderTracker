package io.github.captainwonjong.repositoryImpl.post

import io.github.captainwonjong.entity.post.PostEntity
import io.github.captainwonjong.remote.api.PostService
import io.github.captainwonjong.repository.post.PostRepository
import io.github.captainwonjong.repositoryImpl.post.mapper.PostMapper
import javax.inject.Inject

/**
 * Created by CaptainWonJong@gmail.com on 2023-01-03
 */
class PostRepositoryImpl @Inject constructor(
    private val postService: PostService
) : PostRepository {
    private val mapper = PostMapper()

    override suspend fun getPosts(): List<PostEntity> = postService.get().map {
        mapper.to(it)
    }
}
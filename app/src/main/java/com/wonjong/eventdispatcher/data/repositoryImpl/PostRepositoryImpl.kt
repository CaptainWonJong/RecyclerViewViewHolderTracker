package com.wonjong.eventdispatcher.data.repositoryImpl

import com.wonjong.eventdispatcher.data.repositoryImpl.mapper.PostMapper
import com.wonjong.eventdispatcher.domain.entity.PostEntity
import com.wonjong.eventdispatcher.domain.repository.PostRepository
import io.github.captainwonjong.remote.api.PostService
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
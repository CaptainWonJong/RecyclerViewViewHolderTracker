package io.github.captainwonjong.repository.post

import io.github.captainwonjong.entity.post.PostEntity

/**
 * Created by CaptainWonJong@gmail.com on 2023-01-03
 */
interface PostRepository {
    suspend fun getPosts(): List<PostEntity>
}
package io.github.captainwonjong.usecase.post

import io.github.captainwonjong.entity.post.PostEntity
import io.github.captainwonjong.repository.post.PostRepository
import javax.inject.Inject

/**
 * Created by CaptainWonJong@gmail.com on 2023-01-03
 */
class GetPosts @Inject constructor(
    private val postRepository: PostRepository
) {
    suspend fun execute(): Result<List<PostEntity>> = runCatching {
        postRepository.getPosts()
    }
}
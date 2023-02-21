package io.github.captainwonjong.remote.api

import io.github.captainwonjong.model.post.PostRaw
import retrofit2.http.GET

/**
 * Created by CaptainWonJong@gmail.com on 2023-01-03
 */
interface PostService {

    @GET("posts")
    suspend fun get(): List<PostRaw>
}
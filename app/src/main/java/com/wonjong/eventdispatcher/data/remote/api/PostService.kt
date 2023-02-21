package com.wonjong.eventdispatcher.data.remote.api

import io.github.captainwonjong.model.post.PostRaw
import retrofit2.http.GET

/**
 * Created by leewonjong@29cm.co.kr on 2023-01-03
 */
interface PostService {

    @GET("posts")
    suspend fun get(): List<PostRaw>
}
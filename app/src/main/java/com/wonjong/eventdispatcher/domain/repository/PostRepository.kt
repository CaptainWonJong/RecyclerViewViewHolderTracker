package com.wonjong.eventdispatcher.domain.repository

import com.wonjong.eventdispatcher.domain.entity.PostEntity

/**
 * Created by CaptainWonJong@gmail.com on 2023-01-03
 */
interface PostRepository {
    suspend fun getPosts(): List<PostEntity>
}
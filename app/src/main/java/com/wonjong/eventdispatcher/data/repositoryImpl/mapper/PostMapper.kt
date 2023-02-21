package com.wonjong.eventdispatcher.data.repositoryImpl.mapper

import android.graphics.Color
import com.wonjong.eventdispatcher.domain.entity.PostEntity
import io.github.captainwonjong.model.post.PostRaw
import java.util.*

/**
 * Created by CaptainWonJong@gmail.com on 2023-01-03
 */
class PostMapper {
    fun to(from: PostRaw): PostEntity {
        val rnd = Random()
        return PostEntity(
            id = from.id,
            body = from.body,
            title = from.title,
            colorInt = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256)),
            userId = from.userId
        )
    }
}
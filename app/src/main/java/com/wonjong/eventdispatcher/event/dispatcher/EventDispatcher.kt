package com.wonjong.eventdispatcher.event.dispatcher

/**
 * Created by CaptainWonJong@gmail.com on 2023-01-06
 */
interface EventDispatcher {
    fun dispatchEvent(events: Events)
}
package xyz.dokup.talknotifier.api

import io.reactivex.Single
import xyz.dokup.talknotifier.api.service.TalkNotifierService
import xyz.dokup.talknotifier.model.Event
import xyz.dokup.talknotifier.model.Talk
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by e10dokup on 2017/11/13.
 */
@Singleton class TalkNotifierClient @Inject constructor(
        private val talkNotifierService: TalkNotifierService
) {

    fun getEvents(): Single<List<Event>> {
        return talkNotifierService.getEvents()
    }

    fun getTalks(eventId: Int): Single<List<Talk>> {
        return talkNotifierService.getTalks(eventId)
    }

    fun connection(eventId: Int, talkId: Int): Single<Talk> {
        return talkNotifierService.connection(eventId, talkId)
    }

}
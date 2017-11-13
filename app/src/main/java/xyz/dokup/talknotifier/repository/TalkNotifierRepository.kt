package xyz.dokup.talknotifier.repository

import io.reactivex.Single
import xyz.dokup.talknotifier.datasource.TalkNotifierRemoteDataSource
import xyz.dokup.talknotifier.model.Event
import xyz.dokup.talknotifier.model.Talk
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by e10dokup on 2017/11/14.
 */
@Singleton class TalkNotifierRepository @Inject constructor(
        private val talkNotifierRemoteDataSource: TalkNotifierRemoteDataSource
) {

    fun getEvents(): Single<List<Event>> {
        return talkNotifierRemoteDataSource.getEvents()
    }

    fun getTalks(eventId: Int): Single<List<Talk>> {
        return talkNotifierRemoteDataSource.getTalks(eventId)
    }

    fun connection(eventId: Int, talkId: Int): Single<Talk> {
        return talkNotifierRemoteDataSource.connection(eventId, talkId)
    }

}
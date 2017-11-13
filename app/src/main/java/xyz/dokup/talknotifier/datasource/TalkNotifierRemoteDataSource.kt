package xyz.dokup.talknotifier.datasource

import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import xyz.dokup.talknotifier.api.TalkNotifierClient
import xyz.dokup.talknotifier.model.Event
import xyz.dokup.talknotifier.model.Talk
import javax.inject.Inject

/**
 * Created by e10dokup on 2017/11/14.
 */
class TalkNotifierRemoteDataSource @Inject constructor(
        private val client: TalkNotifierClient
) {
    fun getEvents(): Single<List<Event>> {
        return client.getEvents()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    }

    fun getTalks(eventId: Int): Single<List<Talk>> {
        return client.getTalks(eventId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    }

    fun connection(eventId: Int, talkId: Int): Single<Talk> {
        return client.connection(eventId, talkId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    }
}
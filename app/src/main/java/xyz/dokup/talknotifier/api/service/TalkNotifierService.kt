package xyz.dokup.talknotifier.api.service

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import xyz.dokup.talknotifier.model.Event
import xyz.dokup.talknotifier.model.Talk

/**
 * Created by e10dokup on 2017/11/13.
 */
interface TalkNotifierService {

    @GET("api/event")
    fun getEvents(): Single<List<Event>>

    @GET("api/event/{event_id}/talk")
    fun getTalks(@Path("event_id") eventId: Int): Single<List<Talk>>

    @GET("api/connect{event_id}/{talk_id}")
    fun connection(@Path("event_id") eventId: Int, @Path("talk_id") talkId: Int): Single<Talk>


}
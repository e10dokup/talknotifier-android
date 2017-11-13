package xyz.dokup.talknotifier.model

/**
 * Created by e10dokup on 2017/11/13.
 */
data class Talk(
        val id: Int,
        val event_id: Int,
        val speaker: String,
        val title: String
)
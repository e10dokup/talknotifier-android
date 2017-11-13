package xyz.dokup.talknotifier.view.util

import android.support.v7.app.AppCompatActivity
import xyz.dokup.talknotifier.di.scope.ActivityScope
import xyz.dokup.talknotifier.extension.go
import xyz.dokup.talknotifier.view.activity.ListingActivity.Companion.EVENT_ID
import javax.inject.Inject

/**
 * Created by e10dokup on 2017/11/13.
 */
@ActivityScope
class Navigator @Inject constructor(activity: AppCompatActivity){

    private val activity = activity

    fun NavigateToListing(eventId: Int) {
        activity.go(Page.LISTING) { it.putExtra(EVENT_ID, eventId) }
    }

}
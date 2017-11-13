package xyz.dokup.talknotifier.view.util

import android.support.v7.app.AppCompatActivity
import xyz.dokup.talknotifier.di.scope.ActivityScope
import javax.inject.Inject

/**
 * Created by e10dokup on 2017/11/13.
 */
@ActivityScope
class Navigator @Inject constructor(activity: AppCompatActivity){

    private val activity = activity

    fun NavigateToListing() {
        // activity.go(Page.SETTING)
    }

}
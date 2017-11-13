package xyz.dokup.talknotifier.di

import dagger.Subcomponent
import xyz.dokup.talknotifier.di.scope.ActivityScope
import xyz.dokup.talknotifier.view.activity.ListingActivity
import xyz.dokup.talknotifier.view.activity.MainActivity

/**
 * Created by e10dokup on 2017/11/13.
 */
@ActivityScope
@Subcomponent(modules = arrayOf(ActivityModule::class))
interface ActivityComponent {

    fun inject(activity: MainActivity)
    fun inject(activity: ListingActivity)

    fun plus(module: FragmentModule): FragmentComponent
}
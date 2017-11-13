package xyz.dokup.talknotifier.di

import dagger.Subcomponent
import xyz.dokup.talknotifier.view.activity.MainActivity
import xyz.dokup.talknotifier.di.scope.ActivityScope

/**
 * Created by e10dokup on 2017/11/13.
 */
@ActivityScope
@Subcomponent(modules = arrayOf(ActivityModule::class))
interface ActivityComponent {

    fun inject(activity: MainActivity)

    fun plus(module: FragmentModule): FragmentComponent
}
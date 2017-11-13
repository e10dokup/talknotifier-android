package xyz.dokup.talknotifier.di

import dagger.Subcomponent
import xyz.dokup.talknotifier.di.scope.FragmentScope

/**
 * Created by e10dokup on 2017/11/13.
 */
@FragmentScope
@Subcomponent(modules = arrayOf(FragmentModule::class))
interface FragmentComponent {
}
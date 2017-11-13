package xyz.dokup.talknotifier.di

import dagger.Component
import xyz.dokup.talknotifier.MyApplication
import javax.inject.Singleton

/**
 * Created by e10dokup on 2017/11/13.
 */
@Singleton
@Component(modules = arrayOf(AppModule::class))
interface AppComponent {

    fun inject(application: MyApplication)

    fun plus(module: ActivityModule): ActivityComponent
}
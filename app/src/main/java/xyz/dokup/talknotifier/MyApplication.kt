package xyz.dokup.talknotifier

import android.app.Application
import com.jakewharton.threetenabp.AndroidThreeTen
import timber.log.Timber
import xyz.dokup.talknotifier.di.AppComponent
import xyz.dokup.talknotifier.di.AppModule
import xyz.dokup.talknotifier.di.DaggerAppComponent

/**
 * Created by e10dokup on 2017/11/13.
 */
class MyApplication: Application() {

    lateinit var component: AppComponent

    override fun onCreate() {
        super.onCreate()

        component = DaggerAppComponent.builder().appModule(AppModule(this)).build()
        component.inject(this)

        AndroidThreeTen.init(this)
        Timber.plant(Timber.DebugTree())
    }
}

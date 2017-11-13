package xyz.dokup.talknotifier.di

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import dagger.Module
import dagger.Provides

/**
 * Created by e10dokup on 2017/11/13.
 */
@Module
class FragmentModule(private val fragment: Fragment) {

    @Provides
    fun provideFragmentManager(): FragmentManager {
        return fragment.fragmentManager
    }

}
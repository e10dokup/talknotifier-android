package xyz.dokup.talknotifier.viewmodel.base

/**
 * Created by e10dokup on 2017/11/13.
 */
abstract class ActivityViewModel {

    abstract fun onStart()

    abstract fun onResume()

    abstract fun onPause()

    abstract fun onStop()
}
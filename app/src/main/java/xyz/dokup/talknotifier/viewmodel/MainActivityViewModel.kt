package xyz.dokup.talknotifier.viewmodel

import android.content.Context
import xyz.dokup.talknotifier.viewmodel.base.ActivityViewModel
import xyz.dokup.talknotifier.view.util.Navigator
import javax.inject.Inject

/**
 * Created by e10dokup on 2017/11/13.
 */
class MainActivityViewModel @Inject constructor(
        context: Context,
        private val navigator: Navigator): ActivityViewModel() {

    init {
    }

    override fun onStart() {
    }

    override fun onResume() {
    }

    override fun onPause() {
    }

    override fun onStop() {
    }
}
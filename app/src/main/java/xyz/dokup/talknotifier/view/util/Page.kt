package xyz.dokup.talknotifier.view.util

import android.content.Context
import android.content.Intent
import xyz.dokup.talknotifier.view.activity.MainActivity
import xyz.dokup.talknotifier.view.activity.base.BaseActivity

/**
 * Created by e10dokup on 2017/11/13.
 */
enum class Page(private val target: Class<out BaseActivity>) {
    MAIN(MainActivity::class.java),
    LISTING(MainActivity::class.java);

    open fun intent(context: Context) = Intent(context, target)
}
package xyz.dokup.talknotifier.di.provider

import android.content.Context
import xyz.dokup.talknotifier.model.OrmaDatabase

/**
 * Created by e10dokup on 2017/11/13.
 */
class OrmaProvider(context: Context) {

    val ormaDatabase: OrmaDatabase = OrmaDatabase.builder(context).build()

}
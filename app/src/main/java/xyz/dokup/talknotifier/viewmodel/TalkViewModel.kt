package xyz.dokup.talknotifier.viewmodel

import android.databinding.ObservableBoolean
import android.databinding.ObservableField
import android.view.View
import xyz.dokup.talknotifier.model.Talk

/**
 * Created by e10dokup on 2017/11/14.
 */
class TalkViewModel constructor(
        val talk: Talk,
        private val onChangeCurrentTalk: ((TalkViewModel) -> Unit)
) {

    private var observableTalk: ObservableField<Talk> = ObservableField(talk)
    var current = ObservableBoolean(false)

    fun onItemClick(view: View) {
        onChangeCurrentTalk.invoke(this)
    }

}
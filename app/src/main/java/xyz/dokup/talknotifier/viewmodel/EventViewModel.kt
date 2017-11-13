package xyz.dokup.talknotifier.viewmodel

import android.databinding.ObservableField
import android.view.View
import xyz.dokup.talknotifier.model.Event
import xyz.dokup.talknotifier.view.util.Navigator

/**
 * Created by e10dokup on 2017/11/14.
 */
public class EventViewModel constructor(
        private val navigator: Navigator,
        val event: Event
) {

    private var observableEvent: ObservableField<Event> = ObservableField(event)

    fun onItemClick(view: View) {
        navigator.NavigateToListing()
    }

}
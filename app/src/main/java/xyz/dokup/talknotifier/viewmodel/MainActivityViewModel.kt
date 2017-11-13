package xyz.dokup.talknotifier.viewmodel

import android.databinding.ObservableArrayList
import xyz.dokup.talknotifier.model.Event
import xyz.dokup.talknotifier.repository.TalkNotifierRepository
import xyz.dokup.talknotifier.view.util.Navigator
import xyz.dokup.talknotifier.viewmodel.base.ActivityViewModel
import javax.inject.Inject


/**
 * Created by e10dokup on 2017/11/13.
 */
class MainActivityViewModel @Inject constructor(
        private val navigator: Navigator,
        private val talkNotifierRepository: TalkNotifierRepository
): ActivityViewModel() {

    val eventViewModels = ObservableArrayList<EventViewModel>()

    override fun onStart() {
    }

    override fun onResume() {
        talkNotifierRepository.getEvents()
                .map { convertToViewModel(it) }
                .subscribe { e ->
                    this.eventViewModels.clear()
                    this.eventViewModels.addAll(e)
                }

    }

    override fun onPause() {
    }

    override fun onStop() {
    }

    private fun convertToViewModel(events: List<Event>): List<EventViewModel> {
        return events.map { event -> EventViewModel(navigator, event) }.toList()
    }
}
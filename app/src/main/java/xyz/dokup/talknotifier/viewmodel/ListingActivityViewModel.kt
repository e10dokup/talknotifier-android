package xyz.dokup.talknotifier.viewmodel

import android.databinding.ObservableArrayList
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import xyz.dokup.talknotifier.model.Talk
import xyz.dokup.talknotifier.repository.TalkNotifierRepository
import xyz.dokup.talknotifier.viewmodel.base.ActivityViewModel
import javax.inject.Inject

/**
 * Created by e10dokup on 2017/11/13.
 */
class ListingActivityViewModel @Inject constructor(
        private val activity: AppCompatActivity,
        private val talkNotifierRepository: TalkNotifierRepository
): ActivityViewModel() {

    val talkViewModels = ObservableArrayList<TalkViewModel>()

    var eventId = 0
    private var currentTalk: TalkViewModel? = null

    override fun onStart() {
    }

    override fun onResume() {
        talkNotifierRepository.getTalks(eventId)
                .map { convertToViewModel(it) }
                .subscribe { t ->
                    this.talkViewModels.clear()
                    this.talkViewModels.addAll(t)
                }

    }

    override fun onPause() {
    }

    override fun onStop() {
    }

    fun onNotifyClick(view: View) {
        currentTalk ?: return
        talkNotifierRepository.connection(currentTalk!!.talk.event_id, currentTalk!!.talk.id)
                .subscribe { _ ->
                    Toast.makeText(activity, currentTalk!!.talk.title + "の通知が完了しました", Toast.LENGTH_SHORT).show()
                }
    }

    private fun convertToViewModel(talks: List<Talk>): List<TalkViewModel> {
        return talks.map { t -> TalkViewModel(t) {
            currentTalk?.current?.set(false)
            currentTalk = it
            currentTalk?.current?.set(true)
        } }.toList()
    }
}
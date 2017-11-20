package xyz.dokup.talknotifier.viewmodel

import android.databinding.ObservableArrayList
import android.databinding.ObservableBoolean
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
    val idList = ArrayList<Int>()
    var posting = ObservableBoolean(false)

    var eventId = 0
    private var currentTalk: TalkViewModel? = null

    override fun onStart() {
    }

    override fun onResume() {
        talkNotifierRepository.getTalks(eventId)
                .map { t: List<Talk> ->
                    val uniqueTalk = ArrayList<Talk>()
                    t.forEach {
                        if (!idList.contains(it.id)) {
                            uniqueTalk.add(it)
                        }
                    }
                    return@map uniqueTalk
                }
                .map { convertToViewModel(it) }
                .subscribe { t ->
                    this.talkViewModels.addAll(t)
                }
    }

    override fun onPause() {
    }

    override fun onStop() {
    }

    fun onNotifyClick(view: View) {
        currentTalk ?: return
        posting.set(true)
        talkNotifierRepository.connection(currentTalk!!.talk.event_id, currentTalk!!.talk.id)
                .subscribe({ _ ->
                    Toast.makeText(activity, currentTalk!!.talk.title + "の通知が完了しました", Toast.LENGTH_SHORT).show()
                    currentTalk?.done?.set(true)
                    posting.set(false)
                }, { _ ->
                    Toast.makeText(activity, "何かがおかしいよ！作った人に言ってね！", Toast.LENGTH_SHORT).show()
                    posting.set(false)
                })

    }

    private fun convertToViewModel(talks: List<Talk>): List<TalkViewModel> {
        return talks.map { t ->
            idList.add(t.id)
            TalkViewModel(t) {
                currentTalk?.current?.set(false)
                currentTalk = it
                currentTalk?.current?.set(true)
            }
        }.toList()
    }
}
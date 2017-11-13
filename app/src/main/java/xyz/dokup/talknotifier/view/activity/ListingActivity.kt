package xyz.dokup.talknotifier.view.activity

import android.content.Context
import android.databinding.DataBindingUtil
import android.databinding.ObservableList
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuItem
import android.view.ViewGroup
import xyz.dokup.talknotifier.R
import xyz.dokup.talknotifier.databinding.ActivityListingBinding
import xyz.dokup.talknotifier.databinding.ItemTalkBinding
import xyz.dokup.talknotifier.view.activity.base.BaseActivity
import xyz.dokup.talknotifier.view.adapter.BindingHolder
import xyz.dokup.talknotifier.view.adapter.ObservableListRecyclerAdapter
import xyz.dokup.talknotifier.viewmodel.ListingActivityViewModel
import xyz.dokup.talknotifier.viewmodel.TalkViewModel
import javax.inject.Inject


class ListingActivity : BaseActivity() {

    @Inject
    lateinit var viewModel: ListingActivityViewModel

    private lateinit var binding: ActivityListingBinding

    companion object {
        const val EVENT_ID = "event_id"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        component.inject(this)
        bindViewModel(viewModel)
        viewModel.eventId = intent.getIntExtra(EVENT_ID, 0)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_listing)
        binding.viewModel = viewModel

        // setSupportActionBar(binding.toolbar)
        initBackToolbar(binding.toolbar)

        initRecyclerView()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_settings -> return true
        }
        return super.onOptionsItemSelected(item)
    }

    private fun initRecyclerView() {
        val adapter = TalkAdapter(this, viewModel.talkViewModels)
        binding.eventRecycler.adapter = adapter
        binding.eventRecycler.setHasFixedSize(true)
        binding.eventRecycler.layoutManager = LinearLayoutManager(this)
    }

    private inner class TalkAdapter(
            context: Context,
            list: ObservableList<TalkViewModel>
    ) : ObservableListRecyclerAdapter<TalkViewModel, BindingHolder<ItemTalkBinding>>(context, list) {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BindingHolder<ItemTalkBinding> {
            return BindingHolder(context, parent, R.layout.item_talk)
        }

        override fun onBindViewHolder(holder: BindingHolder<ItemTalkBinding>, position: Int) {
            val viewModel = getItem(position)
            val binding = holder.binding
            binding.viewModel = viewModel
        }

        override fun getItemId(position: Int): Long {
            val viewModel = getItem(position)
            return viewModel.talk.id.toLong()
        }
    }
}
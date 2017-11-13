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
import xyz.dokup.talknotifier.databinding.ActivityMainBinding
import xyz.dokup.talknotifier.databinding.ItemEventBinding
import xyz.dokup.talknotifier.view.activity.base.BaseActivity
import xyz.dokup.talknotifier.view.adapter.BindingHolder
import xyz.dokup.talknotifier.view.adapter.ObservableListRecyclerAdapter
import xyz.dokup.talknotifier.viewmodel.EventViewModel
import xyz.dokup.talknotifier.viewmodel.MainActivityViewModel
import javax.inject.Inject




class MainActivity : BaseActivity() {

    @Inject
    lateinit var viewModel: MainActivityViewModel

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        component.inject(this)
        bindViewModel(viewModel)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.viewModel = viewModel

        setSupportActionBar(binding.toolbar)

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
        val adapter = EventAdapter(this, viewModel.eventViewModels)
        binding.eventRecycler.adapter = adapter
        binding.eventRecycler.setHasFixedSize(true)
        binding.eventRecycler.layoutManager = LinearLayoutManager(this)
    }

    private inner class EventAdapter(
            context: Context,
            list: ObservableList<EventViewModel>
    ) : ObservableListRecyclerAdapter<EventViewModel, BindingHolder<ItemEventBinding>>(context, list) {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BindingHolder<ItemEventBinding> {
            return BindingHolder(context, parent, R.layout.item_event)
        }

        override fun onBindViewHolder(holder: BindingHolder<ItemEventBinding>, position: Int) {
            val viewModel = getItem(position)
            val binding = holder.binding
            binding.viewModel = viewModel
        }

        override fun getItemId(position: Int): Long {
            val viewModel = getItem(position)
            return viewModel.event.id.toLong()
        }
    }
}

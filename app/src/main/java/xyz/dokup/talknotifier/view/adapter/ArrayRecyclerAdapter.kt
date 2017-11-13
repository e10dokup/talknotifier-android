package xyz.dokup.talknotifier.view.adapter

import android.content.Context
import android.support.annotation.UiThread
import android.support.v7.widget.RecyclerView


/**
 * Created by e10dokup on 2017/11/14.
 */
abstract class ArrayRecyclerAdapter<T, VH : RecyclerView.ViewHolder> @JvmOverloads constructor(
        val context: Context,
        private val list: MutableList<T> = ArrayList()
) : RecyclerView.Adapter<VH>() {

    @UiThread
    fun reset(items: Collection<T>) {
        clear()
        addAll(items)
        notifyDataSetChanged()
    }

    fun clear() {
        list.clear()
    }

    fun addAll(items: Collection<T>) {
        list.addAll(items)
    }

    fun getItem(position: Int): T {
        return list[position]
    }

    @UiThread
    fun addAllWithNotify(items: Collection<T>) {
        val position = itemCount
        addAll(items)
        notifyItemInserted(position)
    }

    override fun getItemCount(): Int {
        return list.size
    }
}
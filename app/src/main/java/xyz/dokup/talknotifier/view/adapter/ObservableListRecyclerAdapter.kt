package xyz.dokup.talknotifier.view.adapter

import android.content.Context
import android.databinding.ObservableList
import android.support.v7.widget.RecyclerView



/**
 * Created by e10dokup on 2017/11/14.
 */
abstract class ObservableListRecyclerAdapter<T, VH : RecyclerView.ViewHolder>(
        context: Context,
        list: ObservableList<T>
) : ArrayRecyclerAdapter<T, VH>(context, list) {

    init {

        list.addOnListChangedCallback(object : ObservableList.OnListChangedCallback<ObservableList<T>>() {
            override fun onChanged(ts: ObservableList<T>) {
                notifyDataSetChanged() //データセットの変更をすべてのobserverに通知
            }

            override fun onItemRangeChanged(ts: ObservableList<T>, i: Int, i1: Int) {
                notifyItemRangeChanged(i, i1) // iからi1の範囲において、データの変更があったことをすべてのobserverに通知
            }

            override fun onItemRangeInserted(ts: ObservableList<T>, i: Int, i1: Int) {
                notifyDataSetChanged() //データセットの変更をすべてのobserverに通知
                //                notifyItemRangeInserted(i, i1); // iからi1の範囲において、データの挿入があったことをすべてのobserverに通知
            }

            override fun onItemRangeMoved(ts: ObservableList<T>, i: Int, i1: Int, i2: Int) {
                notifyItemMoved(i, i1) // iからi1へitemが移動したことをobserverに通知
            }

            override fun onItemRangeRemoved(ts: ObservableList<T>, i: Int, i1: Int) {
                notifyItemRangeRemoved(i, i1) // iからi1の範囲のitemがデータセットから削除されたことを通知
            }
        })
    }
}
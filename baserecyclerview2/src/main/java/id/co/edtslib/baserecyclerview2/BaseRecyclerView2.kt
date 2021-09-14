package id.co.edtslib.baserecyclerview2

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

abstract class BaseRecyclerView2: RecyclerView.Adapter<BaseViewHolder<*>>() {
    val list = mutableListOf<AdapterData>()
    var delegate: BaseRecyclerView2AdapterDelegate? = null

    abstract fun createHolder(inflater: LayoutInflater, parent: ViewGroup, viewType: Int): BaseViewHolder<*>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        val inflater = LayoutInflater.from(parent.context)
        return createHolder(inflater, parent, viewType)
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        holder.process(list, position,delegate)
    }

    override fun getItemCount() = list.size
    override fun getItemViewType(position: Int) = list[position].rowType
}
package id.co.edtslib.baserecyclerview2

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

abstract class BaseRecyclerView2: RecyclerView.Adapter<BaseViewHolder<*>>() {
    val list = mutableListOf<AdapterData>()

    abstract fun createHolder(inflater: LayoutInflater, parent: ViewGroup, viewType: Int): BaseViewHolder<*>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        val inflater = LayoutInflater.from(parent.context)
        return createHolder(inflater, parent, viewType)
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        holder.process(list, position)
    }

    override fun getItemCount() = list.size
    override fun getItemViewType(position: Int) = list[position].rowType

    fun getItemCount(viewType: Int): Int {
        var count = 0
        for (item in list) {
            if (item.rowType == viewType) {
                count++
            }
        }

        return count
    }

    inline fun <reified T: Any> getList(viewType: Int): List<T> {
        val l = mutableListOf<T>()
        for (item in list) {
            if (item.rowType == viewType && item.data is T) {
                l.add(item.data)
            }
        }

        return l
    }
}
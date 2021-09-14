package id.co.edtslib.baserecyclerview2

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

open class BaseViewHolder<T>(viewBinding : ViewBinding) : RecyclerView.ViewHolder(viewBinding.root) {
    @Suppress("UNCHECKED_CAST")
    fun process(list: MutableList<AdapterData>, position: Int, delegate: BaseRecyclerView2AdapterDelegate?) {
        val t = list[position].data as T?
        setData(t,delegate)

    }

    open fun setData(t: T?, delegate: BaseRecyclerView2AdapterDelegate?) {}
}
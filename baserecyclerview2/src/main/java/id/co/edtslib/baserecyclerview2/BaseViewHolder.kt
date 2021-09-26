package id.co.edtslib.baserecyclerview2

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

open class BaseViewHolder<T>(val viewBinding : ViewBinding) : RecyclerView.ViewHolder(viewBinding.root) {
    var delegate: BaseRecyclerView2AdapterDelegate<T>? = null

    @Suppress("UNCHECKED_CAST")
    fun process(list: MutableList<AdapterData>, position: Int) {
        val t = list[position].data as T?
        setData(t)

        if (delegate != null) {
            viewBinding.root.setOnClickListener {
                delegate?.onClick(t, position, viewBinding)
            }

            delegate?.onDraw(t, position, viewBinding)
        }
    }

    open fun setData(t: T?) {}
}
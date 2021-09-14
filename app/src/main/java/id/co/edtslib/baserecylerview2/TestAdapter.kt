package id.co.edtslib.baserecylerview2

import android.view.LayoutInflater
import android.view.ViewGroup
import id.co.edtslib.baserecyclerview2.BaseRecyclerView2
import id.co.edtslib.baserecyclerview2.BaseViewHolder
import id.co.edtslib.baserecylerview2.databinding.AdapterHeaderBinding
import id.co.edtslib.baserecylerview2.databinding.AdapterImageBinding
import id.co.edtslib.baserecylerview2.databinding.AdapterItemBinding

class TestAdapter: BaseRecyclerView2() {
    override fun createHolder(
        inflater: LayoutInflater,
        parent: ViewGroup,
        viewType: Int
    ): BaseViewHolder<*> {
        return when(viewType) {
            MyAdapterType.Item.ordinal -> {
                val binding = AdapterItemBinding.inflate(inflater, parent, false)
                TextHolder(binding)
            }
            MyAdapterType.Image.ordinal -> {
                val binding = AdapterImageBinding.inflate(inflater, parent, false)
                ImageHolder(binding)
            }
            else -> {

                val binding = AdapterHeaderBinding.inflate(inflater, parent, false)
                BaseViewHolder<Any>(binding)
            }
        }
    }

}
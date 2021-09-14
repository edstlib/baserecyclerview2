package id.co.edtslib.baserecylerview2

import id.co.edtslib.baserecyclerview2.BaseRecyclerView2AdapterDelegate
import id.co.edtslib.baserecyclerview2.BaseViewHolder
import id.co.edtslib.baserecylerview2.databinding.AdapterItemBinding

class TextHolder(private val binding: AdapterItemBinding): BaseViewHolder<String>(binding) {
    override fun setData(t: String?, delegate: BaseRecyclerView2AdapterDelegate?) {
        binding.textView.text = t
    }

}
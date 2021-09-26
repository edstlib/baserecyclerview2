package id.co.edtslib.baserecylerview2

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import id.co.edtslib.baserecyclerview2.BaseRecyclerView2
import id.co.edtslib.baserecyclerview2.BaseRecyclerView2AdapterDelegate
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
                val holder = ImageHolder(binding)
                holder.delegate = object : BaseRecyclerView2AdapterDelegate<PhotoData> {
                    override fun onClick(t: PhotoData?, position: Int, viewBinding: ViewBinding) {
                    }

                    override fun onDraw(t: PhotoData?, position: Int, viewBinding: ViewBinding) {
                    }
                }

                holder
            }
            else -> {

                val binding = AdapterHeaderBinding.inflate(inflater, parent, false)
                BaseViewHolder<Any>(binding)
            }
        }
    }

}
package id.co.edtslib.baserecylerview2

import com.bumptech.glide.Glide
import id.co.edtslib.baserecyclerview2.BaseRecyclerView2AdapterDelegate
import id.co.edtslib.baserecyclerview2.BaseViewHolder
import id.co.edtslib.baserecylerview2.databinding.AdapterImageBinding

class ImageHolder(private val binding: AdapterImageBinding): BaseViewHolder<PhotoData>(binding) {
    override fun setData(t: PhotoData?, delegate: BaseRecyclerView2AdapterDelegate?) {
        Glide.with(itemView.context).load(t?.url).into(binding.imageView)
        binding.textView.text = t?.caption
    }

}
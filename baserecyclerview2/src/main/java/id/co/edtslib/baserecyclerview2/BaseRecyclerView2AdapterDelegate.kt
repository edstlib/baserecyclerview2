package id.co.edtslib.baserecyclerview2

interface BaseRecyclerView2AdapterDelegate {
    fun onClick(t: AdapterData, position: Int, holder: BaseViewHolder<*>?)
    fun onDraw(t: AdapterData, position: Int)
}
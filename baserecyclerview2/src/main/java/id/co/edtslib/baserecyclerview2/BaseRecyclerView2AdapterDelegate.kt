package id.co.edtslib.baserecyclerview2

import androidx.viewbinding.ViewBinding

interface BaseRecyclerView2AdapterDelegate<T> {
    fun onClick(t: T?, position: Int, viewBinding: ViewBinding)
    fun onDraw(t: T?, position: Int, viewBinding: ViewBinding)
}
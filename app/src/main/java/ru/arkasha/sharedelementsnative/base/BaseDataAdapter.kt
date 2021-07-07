package ru.arkasha.sharedelementsnative.base

import androidx.recyclerview.widget.RecyclerView

abstract class BaseDataAdapter<T, VH : RecyclerView.ViewHolder> : RecyclerView.Adapter<VH>() {

    protected val data = mutableListOf<T>()

    open fun setData(data: List<T>) {
        this.data.clear()
        this.data.addAll(data)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = data.size

}
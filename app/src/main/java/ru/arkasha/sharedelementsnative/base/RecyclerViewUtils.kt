package ru.arkasha.sharedelementsnative.base

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

fun RecyclerView.tuneVertical(adapter: RecyclerView.Adapter<*>, reverse: Boolean = false) {
    this.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, reverse)
    this.adapter = adapter
}

fun RecyclerView.tuneHorizontal(adapter: RecyclerView.Adapter<*>, reverse: Boolean = false) {
    this.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, reverse)
    this.adapter = adapter
}
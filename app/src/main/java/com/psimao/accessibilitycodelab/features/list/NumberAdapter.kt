package com.psimao.accessibilitycodelab.features.list

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.psimao.accessibilitycodelab.R
import com.psimao.accessibilitycodelab.model.NumberItem

class NumberAdapter(private val dataSet: List<NumberItem>, private val listener: ((NumberItem) -> Unit)?)
    : RecyclerView.Adapter<NumberAdapter.ViewHolder>() {

    override fun onBindViewHolder(holder: NumberAdapter.ViewHolder, position: Int) {
        val numberItem = dataSet[position]
        holder.bind(numberItem.number.toString(), numberItem.description, numberItem.color)
        holder.itemView.setOnClickListener { listener?.invoke(numberItem) }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NumberAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.view_number_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = dataSet.size

    inner class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        private val thumbTextView by lazy { view.findViewById<TextView>(R.id.textview_thumb) }
        private val descriptionTextView by lazy { view.findViewById<TextView>(R.id.textview_description) }

        fun bind(thumb: String, description: String, color: Int) {
            thumbTextView.text = thumb
            descriptionTextView.text = description
            thumbTextView.setBackgroundColor(color)
        }
    }
}
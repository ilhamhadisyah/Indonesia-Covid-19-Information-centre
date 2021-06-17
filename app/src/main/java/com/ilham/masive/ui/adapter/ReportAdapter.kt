package com.ilham.masive.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ilham.masive.R
import com.ilham.masive.data.model.ReportModel
import kotlinx.android.synthetic.main.report_item.view.*

class ReportAdapter(val data: List<ReportModel>) : RecyclerView.Adapter<ReportAdapter.ViewHolder>() {
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(data: ReportModel) {
            itemView.apply {
                report_id.text = data.id.toString()
                reporter_name.text = data.reporter
                reported_name.text = data.reported
                report_location.text = data.location
            }

        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ReportAdapter.ViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.report_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ReportAdapter.ViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int = data.size


}
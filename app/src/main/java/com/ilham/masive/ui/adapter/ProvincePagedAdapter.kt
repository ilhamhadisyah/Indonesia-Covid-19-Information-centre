package com.ilham.masive.ui.adapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ilham.masive.R
import com.ilham.masive.data.model.ProvincesCovidCaseModel
import kotlinx.android.synthetic.main.each_province_case.view.*

class ProvincePagedAdapter(val data: List<ProvincesCovidCaseModel>) : RecyclerView.Adapter<ProvincePagedAdapter.ViewHolder>(){
    inner class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        fun bind(data : ProvincesCovidCaseModel){
            itemView.apply {
                indo_case.text = data.Kasus_Posi.toString()
                indo_recover_case.text = data.Kasus_Semb.toString()
                indo_dead_case.text = data.Kasus_Meni.toString()
                province_name.text = data.Provinsi
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ProvincePagedAdapter.ViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.each_province_case, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProvincePagedAdapter.ViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int = data.size


}
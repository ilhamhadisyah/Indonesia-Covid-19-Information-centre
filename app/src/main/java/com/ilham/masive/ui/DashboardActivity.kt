package com.ilham.masive.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.ilham.masive.ApplicationBase
import com.ilham.masive.R
import com.ilham.masive.data.model.ArticlesItem
import com.ilham.masive.data.model.ProvincesCovidCaseModel
import com.ilham.masive.data.model.GlobalDataModel
import com.ilham.masive.data.repository.Resource
import com.ilham.masive.di.ViewModelFactory
import com.ilham.masive.ui.adapter.NewsAdapter
import com.ilham.masive.ui.report.ReportActivity
import com.ilham.masive.viewmodel.DashboardViewModel
import kotlinx.android.synthetic.main.activity_dashboard.*
import javax.inject.Inject

class DashboardActivity : AppCompatActivity() {

    @Inject
    lateinit var factory : ViewModelFactory

    private lateinit var adapter : NewsAdapter
    private val viewModel :DashboardViewModel by viewModels {
        factory
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        (application as ApplicationBase).appComponent.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        supportActionBar?.apply {
            setDisplayShowCustomEnabled(true)
            setCustomView(R.layout.custom_action_bar)
        }
        show_all_case_by_province.setOnClickListener {
            val intent = Intent(this,AllProvincesCovidCaseActivity::class.java)
            startActivity(intent)
        }
        report_a_case.setOnClickListener {
            startActivity(Intent(this,ReportActivity::class.java))
        }

        viewModel.getBantenStatisticData().observe(this, Observer { resource ->
            if (resource != null) {
                when (resource) {
                    is Resource.Success -> {
                        bindBantenData(resource.data)
                    }
                    is Resource.Error -> {
                        Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
                    }
                    is Resource.Loading -> {

                    }
                }
            }
        })
        viewModel.getIndonesiaStatisticData().observe(this, Observer { resource->
            if (resource!=null){
                when(resource){
                    is Resource.Success->{
                        bindIndonesiaData(resource.data)
                    }
                    is Resource.Error->{Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()}
                    is Resource.Loading->{}
                }
            }
        })
        viewModel.getNews().observe(this, Observer { resource->
            if (resource!=null){
                when(resource){
                    is Resource.Success->{
                        setRecyclerView(resource)

                    }
                    is Resource.Loading ->{

                    }
                    is Resource.Error->{
                        Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        })

    }

    private fun setRecyclerView(resource: Resource<List<ArticlesItem>>) {
        rv_news.layoutManager = LinearLayoutManager(this)
        adapter = NewsAdapter(resource.data!!)
        rv_news.adapter = adapter
        adapter.notifyDataSetChanged()
    }

    private fun bindBantenData(data: ProvincesCovidCaseModel?){
        total_case.text = data?.Kasus_Posi.toString()
        total_death.text = data?.Kasus_Meni.toString()
        total_recover.text = data?.Kasus_Semb.toString()
    }
    private fun bindIndonesiaData(data:GlobalDataModel?){
        indo_case.text = data?.positif.toString()
        indo_dead_case.text = data?.meninggal.toString()
        indo_recover_case.text = data?.sembuh.toString()
    }

}
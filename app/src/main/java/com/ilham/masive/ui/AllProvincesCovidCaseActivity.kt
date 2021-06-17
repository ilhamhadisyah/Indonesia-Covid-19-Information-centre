@file:Suppress("SpellCheckingInspection")

package com.ilham.masive.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import androidx.recyclerview.widget.LinearLayoutManager
import com.ilham.masive.ApplicationBase
import com.ilham.masive.R
import com.ilham.masive.data.model.GlobalDataModel
import com.ilham.masive.data.model.ProvincesCovidCaseModel
import com.ilham.masive.data.repository.Resource
import com.ilham.masive.di.ViewModelFactory
import com.ilham.masive.ui.adapter.ProvincePagedAdapter
import com.ilham.masive.viewmodel.AllProvinceIndonesiaViewModel
import kotlinx.android.synthetic.main.activity_all_provinces_covid_case.*
import javax.inject.Inject

class AllProvincesCovidCaseActivity : AppCompatActivity() {
    @Inject
    lateinit var factory : ViewModelFactory

    lateinit var adapter : ProvincePagedAdapter

    private val viewModel : AllProvinceIndonesiaViewModel by viewModels {
        factory
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        (application as ApplicationBase).appComponent.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_all_provinces_covid_case)
        supportActionBar?.apply {
            title = "Covid Case in Indonesia"
            setDisplayHomeAsUpEnabled(true)
        }

        viewModel.getIndonesiaStatisticData().observe(this, Observer { resources->
            when(resources){
                is Resource.Success->{
                    bindIndonesiaData(resources)
                }
                is Resource.Loading->{}
                is Resource.Error->{
                    Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
                }
            }
        })
        setRecyclerView()

    }

    private fun setRecyclerView(){
        rv_each_province.layoutManager = LinearLayoutManager(this)
        viewModel.getProvincesCases().observe(this, Observer { resource->
            when(resource){
                is Resource.Success->{
                    adapter = ProvincePagedAdapter(resource.data!!)
                    rv_each_province.adapter = adapter
                }
                is Resource.Error->{Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()}
                is Resource.Loading->{}
            }
        })
    }

    override fun onBackPressed() {
        super.onBackPressed()
        startActivity(Intent(this,DashboardActivity::class.java))
    }
    private fun bindIndonesiaData(resources: Resource<GlobalDataModel>) {
        val data = resources.data
        positive_indo.text = data?.positif
        dead_indo.text = data?.meninggal
        recover_indo.text = data?.sembuh
    }
}
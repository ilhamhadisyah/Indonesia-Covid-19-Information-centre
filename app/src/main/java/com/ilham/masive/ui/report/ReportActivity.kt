@file:Suppress("DEPRECATION")

package com.ilham.masive.ui.report

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.ilham.masive.ApplicationBase
import com.ilham.masive.R
import com.ilham.masive.data.model.ReportForm
import com.ilham.masive.data.model.ReportModel
import com.ilham.masive.di.ViewModelFactory
import com.ilham.masive.ui.adapter.ProvincePagedAdapter
import com.ilham.masive.ui.adapter.ReportAdapter
import com.ilham.masive.viewmodel.AllProvinceIndonesiaViewModel
import com.ilham.masive.viewmodel.ReportViewModel
import kotlinx.android.synthetic.main.activity_report.*
import javax.inject.Inject

class ReportActivity : AppCompatActivity() {
    @Inject
    lateinit var factory : ViewModelFactory

    lateinit var adapter : ReportAdapter

    private val viewModel : ReportViewModel by viewModels {
        factory
    }
    companion object{
        const val REQ_CODE = 100
        const val DATA_RESULT = "result"
        const val RESULT_CODE = 1001
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        (application as ApplicationBase).appComponent.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_report)

        supportActionBar?.title ="COVID-19 Report"

        viewModel.getReportedData().observe(this, Observer { data->
            report_list.layoutManager = LinearLayoutManager(this)
            adapter = ReportAdapter(data)
            report_list.adapter = adapter
            adapter.notifyDataSetChanged()
        })

        add_report.setOnClickListener{
            val intent = Intent(this,ReportFormActivity::class.java)
            startActivityForResult(intent, REQ_CODE)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when(requestCode){
            REQ_CODE->{
                if (resultCode == RESULT_CODE){
                    viewModel.insertReport(data?.getParcelableExtra(DATA_RESULT)!!)
                    adapter.notifyDataSetChanged()
                }
            }
        }
    }
}
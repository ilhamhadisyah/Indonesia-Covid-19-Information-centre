package com.ilham.masive.ui.report

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ilham.masive.R
import com.ilham.masive.data.model.ReportModel
import com.ilham.masive.ui.report.ReportActivity.Companion.DATA_RESULT
import com.ilham.masive.ui.report.ReportActivity.Companion.RESULT_CODE
import kotlinx.android.synthetic.main.activity_report_form.*
import kotlinx.android.synthetic.main.report_item.*

class ReportFormActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_report_form)
        supportActionBar?.title = "Report A Case"
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setHomeAsUpIndicator(getDrawable(R.drawable.ic_baseline_clear_24))
        }

        submit_report.setOnClickListener {
            val name = reporter_name_edt.text.toString()
            val reported = reported_name_edt.text.toString()
            val location = location.text.toString()

            val data = ReportModel(null,name,reported,location)
            val intentResult = Intent()
            intentResult.putExtra(DATA_RESULT,data)
            setResult(RESULT_CODE,intentResult)
            finish()

        }
    }
}
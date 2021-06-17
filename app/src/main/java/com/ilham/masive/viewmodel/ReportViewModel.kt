package com.ilham.masive.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.ilham.masive.data.model.ReportModel
import com.ilham.masive.data.repository.DataRepository
import javax.inject.Inject

class ReportViewModel @Inject constructor(private val repository : DataRepository):ViewModel() {

    fun getReportedData() : LiveData<List<ReportModel>>{
        return repository.getReportData()
    }

    fun insertReport(data : ReportModel){
        repository.insertReportData(data)
    }
}
package com.ilham.masive.data.repository

import androidx.lifecycle.LiveData
import com.ilham.masive.data.model.ArticlesItem
import com.ilham.masive.data.model.ProvincesCovidCaseModel
import com.ilham.masive.data.model.GlobalDataModel
import com.ilham.masive.data.model.ReportModel

interface DataRepositoryInterface {
    fun getIndonesiaStatistic(): LiveData<Resource<GlobalDataModel>>
    fun getBantenStatistic(): LiveData<Resource<ProvincesCovidCaseModel>>
    fun getProvincesData(): LiveData<Resource<List<ProvincesCovidCaseModel>>>
    fun getNewsData(): LiveData<Resource<List<ArticlesItem>>>
    fun getReportData():LiveData<List<ReportModel>>
    fun insertReportData(data : ReportModel)
}
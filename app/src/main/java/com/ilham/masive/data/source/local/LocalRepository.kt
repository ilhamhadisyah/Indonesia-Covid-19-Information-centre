@file:Suppress("SpellCheckingInspection")

package com.ilham.masive.data.source.local

import androidx.lifecycle.LiveData
import com.ilham.masive.data.model.ArticlesItem
import com.ilham.masive.data.model.ProvincesCovidCaseModel
import com.ilham.masive.data.model.GlobalDataModel
import com.ilham.masive.data.model.ReportModel
import com.ilham.masive.data.source.local.room.Dao
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocalRepository @Inject constructor(private val database: Dao) {
    fun getGlobalData(): LiveData<GlobalDataModel> =
        database.getGlobalData()

    fun getBantenData(): LiveData<ProvincesCovidCaseModel> =
        database.getBantenData()

    fun insertBantenData(data: ProvincesCovidCaseModel) {
        database.insertBantenData(data)
    }

    fun insertGlobalData(data: GlobalDataModel) {
        database.insertGlobalData(data)
    }

    fun getProvincesDataAsPaged():LiveData<List<ProvincesCovidCaseModel>> =
        database.getProvincesData()

    fun insertProvincesData(data : List<ProvincesCovidCaseModel>){
        database.insertProvincesData(data)
    }

    fun getNewsData():LiveData<List<ArticlesItem>> =
        database.getNewsData()

    fun insertNewsData (data : List<ArticlesItem>) =
        database.insertNewsData(data)

    fun getReportData() : LiveData<List<ReportModel>> =
        database.getReportData()

    fun insertReportData(data : ReportModel) =
        database.insertReportData(data)

}
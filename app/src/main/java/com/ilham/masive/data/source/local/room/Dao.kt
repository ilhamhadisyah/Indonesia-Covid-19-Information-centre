@file:Suppress("SpellCheckingInspection")

package com.ilham.masive.data.source.local.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.*
import com.ilham.masive.data.model.ArticlesItem
import com.ilham.masive.data.model.ProvincesCovidCaseModel
import com.ilham.masive.data.model.GlobalDataModel
import com.ilham.masive.data.model.ReportModel


@Dao
interface Dao {

    @Query("SELECT * FROM banten_case where Kode_Provi=36")
    fun getBantenData(): LiveData<ProvincesCovidCaseModel>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertBantenData(model: ProvincesCovidCaseModel): Long

    @Query("SELECT * FROM indonesian_case")
    fun getGlobalData(): LiveData<GlobalDataModel>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertGlobalData(model: GlobalDataModel): Long

    @Query("SELECT * FROM banten_case")
    fun getProvincesData(): LiveData<List<ProvincesCovidCaseModel>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertProvincesData(model: List<ProvincesCovidCaseModel>): LongArray

    @Query("SELECT * FROM news")
    fun getNewsData(): LiveData<List<ArticlesItem>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertNewsData(model: List<ArticlesItem>): LongArray

    @Query("SELECT * FROM case_report")
    fun getReportData(): LiveData<List<ReportModel>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertReportData(model: ReportModel): Long
}
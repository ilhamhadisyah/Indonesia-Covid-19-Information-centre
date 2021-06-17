package com.ilham.masive.data.source.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ilham.masive.data.model.ArticlesItem
import com.ilham.masive.data.model.ProvincesCovidCaseModel
import com.ilham.masive.data.model.GlobalDataModel
import com.ilham.masive.data.model.ReportModel


@Database(entities = [ProvincesCovidCaseModel::class, GlobalDataModel::class, ArticlesItem::class,ReportModel::class], version = 1, exportSchema = false)
//@TypeConverters(Converter::class)
abstract class Databases : RoomDatabase(){
    abstract fun databaseObject(): Dao

}
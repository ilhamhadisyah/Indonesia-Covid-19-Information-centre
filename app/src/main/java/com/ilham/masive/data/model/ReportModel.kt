package com.ilham.masive.data.model

import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "case_report")
@Parcelize
data class ReportModel(
    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "id")
    val id : Int? = 0,

    @ColumnInfo(name = "reporter")
    val reporter : String? = null,

    @ColumnInfo(name = "reported")
    val reported: String? = null,

    @ColumnInfo(name = "location")
    val location : String? = null
):Parcelable

package com.ilham.masive.data.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "province")
data class ProvincesResponse(

    @PrimaryKey(autoGenerate = true)
    val id : Int,

    @ColumnInfo(name = "attributes")
    @field:SerializedName("attributes")
    val attributes: ProvincesCovidCaseModel? = null
):Parcelable

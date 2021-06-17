@file:Suppress("SpellCheckingInspection")

package com.ilham.masive.data.model

import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import retrofit2.http.Field

@Parcelize
@Entity(tableName = "banten_case")
data class ProvincesCovidCaseModel(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "FID")
    @field:SerializedName("FID")
    val FID :Int?,

    @ColumnInfo(name = "Kode_Provi")
    @field:SerializedName("Kode_Provi")
    val Kode_Provi : Int?,

    @ColumnInfo(name = "Provinsi")
    @field:SerializedName("Provinsi")
    val Provinsi : String?,

    @ColumnInfo(name = "Kasus_Posi")
    @field:SerializedName("Kasus_Posi")
    val Kasus_Posi : Int?,

    @ColumnInfo(name = "Kasus_Semb")
    @field:SerializedName("Kasus_Semb")
    val Kasus_Semb : Int?,

    @ColumnInfo(name = "Kasus_Meni")
    @field:SerializedName("Kasus_Meni")
    val Kasus_Meni : Int?

) : Parcelable

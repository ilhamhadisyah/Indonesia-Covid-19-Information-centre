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
@Entity(tableName = "indonesian_case")
data class GlobalDataModel(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "name")
    @field:SerializedName("name")
    val name :String,

    @ColumnInfo(name = "positif")
    @field:SerializedName("positif")
    val positif : String? = null,

    @ColumnInfo(name = "meninggal")
    @field:SerializedName("meninggal")
    val meninggal : String? = null,

    @ColumnInfo(name = "sembuh")
    @field:SerializedName("sembuh")
    val sembuh : String? = null,

    @ColumnInfo(name = "dirawat")
    @field:SerializedName("dirawat")
    val dirawat : String? = null

) : Parcelable

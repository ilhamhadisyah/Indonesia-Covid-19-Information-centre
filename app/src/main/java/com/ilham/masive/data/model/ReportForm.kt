package com.ilham.masive.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ReportForm(
    val reporter: String? = null,
    val reported: String? = null,
    val location: String? = null
) : Parcelable

package com.ilham.masive.data.source.network.retrofit

import com.ilham.masive.data.model.ProvincesResponse
import com.ilham.masive.data.model.GlobalDataModel
import kotlinx.coroutines.Deferred
import retrofit2.http.GET

interface CovidApiService {

    @GET("indonesia")
    fun getIndonesiaStatisticDataAsync(): Deferred<List<GlobalDataModel>>

    @GET("indonesia/provinsi")
    fun getProvinceStatisticDataAsync(): Deferred<List<ProvincesResponse>>


}
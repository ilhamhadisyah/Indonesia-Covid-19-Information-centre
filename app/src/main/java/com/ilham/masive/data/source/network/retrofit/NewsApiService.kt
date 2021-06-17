package com.ilham.masive.data.source.network.retrofit

import com.ilham.masive.data.model.NewsResponse
import kotlinx.coroutines.Deferred
import retrofit2.http.GET

interface NewsApiService {

    @GET("v2/top-headlines?country=id&category=health&apiKey=8251d34aadf24288abea4b34b1becd18")
    fun getIndonesiaStatisticDataAsync(): Deferred<NewsResponse>
}
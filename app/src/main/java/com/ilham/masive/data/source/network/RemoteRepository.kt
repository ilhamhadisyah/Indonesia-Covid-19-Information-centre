@file:Suppress("UNCHECKED_CAST")

package com.ilham.masive.data.source.network

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ilham.masive.data.model.ArticlesItem
import com.ilham.masive.data.model.ProvincesCovidCaseModel
import com.ilham.masive.data.model.GlobalDataModel
import com.ilham.masive.data.model.NewsResponse
import com.ilham.masive.data.source.network.retrofit.CovidApiService
import com.ilham.masive.data.source.network.retrofit.NewsApiService
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class RemoteRepository @Inject constructor(
    private val covidService: CovidApiService,
    private val newsApiService: NewsApiService
) {


    fun getIndonesiaStatistic(): LiveData<ApiResponse<GlobalDataModel>> {
        val result = MutableLiveData<ApiResponse<GlobalDataModel>>()
        GlobalScope.launch {
            val postRequest = covidService.getIndonesiaStatisticDataAsync()
            val postResponse = postRequest.await()[0]
            result.postValue(ApiResponse.success(postResponse))
        }
        return result
    }

    fun getBantenStatistic(): LiveData<ApiResponse<ProvincesCovidCaseModel>> {
        val result = MutableLiveData<ApiResponse<ProvincesCovidCaseModel>>()
        GlobalScope.launch {
            val postRequest = covidService.getProvinceStatisticDataAsync()
            val postResponse = postRequest.await()[6].attributes
            result.postValue(ApiResponse.success(postResponse as ProvincesCovidCaseModel))
        }
        return result
    }

    fun getProvincesStatistic(): LiveData<ApiResponse<List<ProvincesCovidCaseModel>>> {
        val result = MutableLiveData<ApiResponse<List<ProvincesCovidCaseModel>>>()
        val data: ArrayList<ProvincesCovidCaseModel?> = arrayListOf()
        GlobalScope.launch {
            val postRequest = covidService.getProvinceStatisticDataAsync()
            val postResponse = postRequest.await()
            for (a in 0.until(postResponse.size)) {
                data.add(postResponse[a].attributes)
            }
            result.postValue(ApiResponse.success(data as List<ProvincesCovidCaseModel>))
        }
        return result
    }

    fun getNewsData(): LiveData<ApiResponse<List<ArticlesItem>>> {
        val result = MutableLiveData<ApiResponse<List<ArticlesItem>>>()
        GlobalScope.launch {
            val postRequest = newsApiService.getIndonesiaStatisticDataAsync()
            val postResponse = postRequest.await().articles
            result.postValue(ApiResponse.success(postResponse as List<ArticlesItem>))
        }
        return result
    }
}
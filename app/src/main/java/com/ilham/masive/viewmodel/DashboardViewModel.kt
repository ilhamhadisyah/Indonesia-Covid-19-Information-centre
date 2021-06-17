package com.ilham.masive.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ilham.masive.data.model.ArticlesItem
import com.ilham.masive.data.model.ProvincesCovidCaseModel
import com.ilham.masive.data.model.GlobalDataModel
import com.ilham.masive.data.repository.DataRepository
import com.ilham.masive.data.repository.Resource
import javax.inject.Inject

class DashboardViewModel @Inject constructor(private val repository: DataRepository) : ViewModel() {

    fun getBantenStatisticData(): LiveData<Resource<ProvincesCovidCaseModel>> {
        return repository.getBantenStatistic()
    }

    fun getIndonesiaStatisticData(): LiveData<Resource<GlobalDataModel>> {
        return repository.getIndonesiaStatistic()
    }

    fun getNews() :LiveData<Resource<List<ArticlesItem>>>{
        return repository.getNewsData()
    }
}
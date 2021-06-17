package com.ilham.masive.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.ilham.masive.data.model.GlobalDataModel
import com.ilham.masive.data.model.ProvincesCovidCaseModel
import com.ilham.masive.data.repository.DataRepository
import com.ilham.masive.data.repository.Resource
import javax.inject.Inject

class AllProvinceIndonesiaViewModel @Inject constructor(private val repository: DataRepository) : ViewModel() {

    fun getIndonesiaStatisticData(): LiveData<Resource<GlobalDataModel>> {
        return repository.getIndonesiaStatistic()
    }

    fun getProvincesCases() : LiveData<Resource<List<ProvincesCovidCaseModel>>>{
        return repository.getProvincesData()
    }
}
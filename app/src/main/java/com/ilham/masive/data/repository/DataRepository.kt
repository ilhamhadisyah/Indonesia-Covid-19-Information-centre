package com.ilham.masive.data.repository

import androidx.lifecycle.LiveData
import com.ilham.masive.data.model.ArticlesItem
import com.ilham.masive.data.model.ProvincesCovidCaseModel
import com.ilham.masive.data.model.GlobalDataModel
import com.ilham.masive.data.model.ReportModel
import com.ilham.masive.data.source.local.LocalRepository
import com.ilham.masive.data.source.network.ApiResponse
import com.ilham.masive.data.source.network.RemoteRepository
import com.ilham.masive.utils.AppExecutor
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class DataRepository @Inject constructor(
    private var localRepository: LocalRepository,
    private var remoteRepository: RemoteRepository,
    private var appExecutor: AppExecutor
) : DataRepositoryInterface {
    override fun getIndonesiaStatistic(): LiveData<Resource<GlobalDataModel>> {
        return object : NetworkBoundResource<GlobalDataModel, GlobalDataModel>(appExecutor) {
            override fun loadFromDB(): LiveData<GlobalDataModel> {
                return localRepository.getGlobalData()
            }

            override fun shouldFetch(data: GlobalDataModel?): Boolean = true

            override fun createCall(): LiveData<ApiResponse<GlobalDataModel>> {
                return remoteRepository.getIndonesiaStatistic()
            }

            override fun saveCallResult(data: GlobalDataModel) {
                localRepository.insertGlobalData(data)
            }

        }.asLiveData()
    }

    override fun getBantenStatistic(): LiveData<Resource<ProvincesCovidCaseModel>> {
        return object :
            NetworkBoundResource<ProvincesCovidCaseModel, ProvincesCovidCaseModel>(appExecutor) {
            override fun loadFromDB(): LiveData<ProvincesCovidCaseModel> {
                return localRepository.getBantenData()
            }

            override fun shouldFetch(data: ProvincesCovidCaseModel?): Boolean = true

            override fun createCall(): LiveData<ApiResponse<ProvincesCovidCaseModel>> {
                return remoteRepository.getBantenStatistic()
            }

            override fun saveCallResult(data: ProvincesCovidCaseModel) {
                localRepository.insertBantenData(data)
            }

        }.asLiveData()
    }

    override fun getProvincesData(): LiveData<Resource<List<ProvincesCovidCaseModel>>> {
        return object : NetworkBoundResource<List<ProvincesCovidCaseModel>,List<ProvincesCovidCaseModel>>(appExecutor){
            override fun loadFromDB(): LiveData<List<ProvincesCovidCaseModel>> {
                return localRepository.getProvincesDataAsPaged()
            }

            override fun shouldFetch(data: List<ProvincesCovidCaseModel>?): Boolean = true

            override fun createCall(): LiveData<ApiResponse<List<ProvincesCovidCaseModel>>>? {
                return remoteRepository.getProvincesStatistic()
            }

            override fun saveCallResult(data: List<ProvincesCovidCaseModel>) {
                localRepository.insertProvincesData(data)
            }

        }.asLiveData()
    }

    override fun getNewsData(): LiveData<Resource<List<ArticlesItem>>> {
        return object : NetworkBoundResource<List<ArticlesItem>,List<ArticlesItem>>(appExecutor){
            override fun loadFromDB(): LiveData<List<ArticlesItem>> {
                return localRepository.getNewsData()
            }

            override fun shouldFetch(data: List<ArticlesItem>?): Boolean =true

            override fun createCall(): LiveData<ApiResponse<List<ArticlesItem>>>? {
                return remoteRepository.getNewsData()
            }

            override fun saveCallResult(data: List<ArticlesItem>) {
                localRepository.insertNewsData(data)
            }

        }.asLiveData()
    }

    override fun getReportData(): LiveData<List<ReportModel>> {
        return localRepository.getReportData()
    }

    override fun insertReportData(data: ReportModel) {
        val runnable  = Runnable { localRepository.insertReportData(data) }
        appExecutor.diskIO().execute(runnable)
    }


}
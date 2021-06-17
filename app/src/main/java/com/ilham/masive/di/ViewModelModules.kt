package com.ilham.masive.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ilham.masive.viewmodel.AllProvinceIndonesiaViewModel
import com.ilham.masive.viewmodel.DashboardViewModel
import com.ilham.masive.viewmodel.ReportViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Suppress("unused")
@Module
abstract class ViewModelModules {

    @Binds
    @IntoMap
    @ViewModelKey(DashboardViewModel::class)
    abstract fun bindDashboardViewModel(viewModel: DashboardViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(AllProvinceIndonesiaViewModel::class)
    abstract fun bindIndonesiaAllCase(viewModel: AllProvinceIndonesiaViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ReportViewModel::class)
    abstract fun bindReportCase(viewModel: ReportViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}
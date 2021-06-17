package com.ilham.masive.di

import android.content.Context
import com.ilham.masive.ui.AllProvincesCovidCaseActivity
import com.ilham.masive.ui.DashboardActivity
import com.ilham.masive.ui.report.ReportActivity
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [ViewModelModules::class,AppModule::class])
interface AppComponent {
    @Component.Factory
    interface Factory{
        fun create(@BindsInstance context : Context):AppComponent
    }

    fun inject(activity : DashboardActivity)
    fun inject(activity: AllProvincesCovidCaseActivity)
    fun inject(activity: ReportActivity)
}
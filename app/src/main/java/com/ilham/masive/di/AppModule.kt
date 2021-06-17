package com.ilham.masive.di

import android.content.Context
import androidx.room.Room
import com.ilham.masive.BuildConfig
import com.ilham.masive.data.source.local.room.Dao
import com.ilham.masive.data.source.local.room.Databases
import com.ilham.masive.data.source.network.retrofit.CovidApiService
import com.ilham.masive.data.source.network.retrofit.NewsApiService
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
class AppModule {
    @Singleton
    @Provides
    fun provideDatabase(context: Context): Databases = Room.databaseBuilder(
        context, Databases::class.java, "Covid.db"
    ).fallbackToDestructiveMigration().build()

    @Singleton
    @Provides
    fun provideMovieDao(databases: Databases): Dao = databases.databaseObject()

    @Singleton
    @Provides
    fun provideCovidApiService(): CovidApiService = Retrofit.Builder().baseUrl(BuildConfig.COVID_BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .build()
        .create(CovidApiService::class.java)

    @Singleton
    @Provides
    fun provideNewsApiService(): NewsApiService = Retrofit.Builder().baseUrl(BuildConfig.NEWS_NEWS_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .build()
        .create(NewsApiService::class.java)
}
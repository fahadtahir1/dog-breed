package com.arbisoft.dogbreedsearch.di

import android.app.Application
import android.content.Context
import com.arbisoft.dogbreedsearch.utils.CommonConstants
import com.arbisoft.dogbreedsearch.utils.ResourceProvider
import com.arbisoft.dogbreedsearch.managers.DataManager
import com.arbisoft.dogbreedsearch.managers.DataManagerImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
object AppModule {
    @Provides
    @Singleton
    fun provideContext(application: Application): Context {
        return application
    }


    @Provides
    fun providePreferenceName(): String {
        return CommonConstants.PREF_NAME
    }
    
    @Provides
    fun provideResourceProvider(context: Context): ResourceProvider {
        return ResourceProvider(context.applicationContext)
    }

    @Singleton
    @Provides
    fun provideDataManager(dataManagerImpl: DataManagerImpl): DataManager {
        return dataManagerImpl
    }
    
}
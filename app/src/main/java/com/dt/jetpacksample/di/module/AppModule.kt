package com.dt.jetpacksample.di.module

import android.app.Application
import androidx.room.Room
import com.dt.jetpacksample.api.JetPackApi
import com.dt.jetpacksample.repository.TestRepository
import com.dt.jetpacksample.room.AppDb
import com.dt.jetpacksample.room.dao.TestApiDao
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton


@Module(includes = [ViewModelModule::class])
class AppModule {


    @Provides
    fun provideName(): String {
        return "From App Module"
    }

    @Provides
    fun provideApi(retrofit: Retrofit): JetPackApi {
        return retrofit.create(JetPackApi::class.java)
    }


    @Singleton
    @Provides
    fun providesRepository(jetPackApi: JetPackApi): TestRepository {
        return TestRepository(jetPackApi)
    }

    @Provides
    @Singleton
    internal fun provideAppDatabase(application: Application): AppDb {
        return Room.databaseBuilder(application, AppDb::class.java, "jetpack.db").allowMainThreadQueries().build()
    }


    @Provides
    @Singleton
    internal fun provideTestApiDao(appDb: AppDb): TestApiDao {
        return appDb.testDao()
    }

}
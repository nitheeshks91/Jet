package com.dt.jetpacksample.di.component

import android.app.Application
import com.dt.jetpacksample.JetPackApplication
import com.dt.jetpacksample.di.module.ActivityModule
import com.dt.jetpacksample.di.module.AppModule
import com.dt.jetpacksample.di.module.NetworkModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidInjectionModule::class, ActivityModule::class, AppModule::class,NetworkModule::class])
interface AppComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(application: JetPackApplication)
}
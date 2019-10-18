package com.dt.jetpacksample.di.module

import com.dt.jetpacksample.views.HomeFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class FragmentBuilderModule {

    @ContributesAndroidInjector
    abstract fun contributeHomeFragment(): HomeFragment


}
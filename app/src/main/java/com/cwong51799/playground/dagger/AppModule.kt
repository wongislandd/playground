package com.cwong51799.playground.dagger

import com.cwong51799.api.APIActivity
import com.cwong51799.playground.MainActivity
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

@Module
abstract class AppModule {
    @ActivityScope @ContributesAndroidInjector()
    abstract fun contributesMainActivityInjector(): MainActivity

    @ActivityScope @ContributesAndroidInjector()
    abstract fun contributesAPIActivityInjector(): APIActivity
}
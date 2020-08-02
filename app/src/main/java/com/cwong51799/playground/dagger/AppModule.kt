package com.cwong51799.playground.dagger

import com.cwong51799.api.APIActivity
import com.cwong51799.playground.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class AppModule {
    @ActivityScope @ContributesAndroidInjector()
    abstract fun contributesMainActivityInjector(): MainActivity

    @ActivityScope @ContributesAndroidInjector()
    abstract fun contributesAPIActivityInjector(): APIActivity
}
package com.cwong51799.playground.di

import com.cwong51799.api.APIActivity
import com.cwong51799.playground.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

@Module(includes = [
    AndroidSupportInjectionModule::class
])
abstract class AppModule {
    @ActivityScope @ContributesAndroidInjector()
    abstract fun contributesMainActivityInjector(): MainActivity

    @ActivityScope @ContributesAndroidInjector()
    abstract fun contributesModuleActivityInjector(): APIActivity
}
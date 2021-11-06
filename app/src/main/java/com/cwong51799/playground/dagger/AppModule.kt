package com.cwong51799.playground.dagger

import com.cwong51799.api.APIActivity
import com.cwong51799.core.dagger.ActivityScope
import com.cwong51799.playground.MainActivity
import com.cwong51799.database_module.DatabaseActivity
//import com.cwong51799.module_hajime.HajimeActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class AppModule {
    @ActivityScope
    @ContributesAndroidInjector()
    abstract fun contributesMainActivityInjector(): MainActivity

    @ActivityScope @ContributesAndroidInjector()
    abstract fun contributesAPIActivityInjector(): APIActivity

    @ActivityScope @ContributesAndroidInjector()
    abstract fun contributesDatabaseActivityInjector(): DatabaseActivity

//    @ActivityScope @ContributesAndroidInjector()
//    abstract fun contributesComposeActivityInjector(): ComposeActivity
}
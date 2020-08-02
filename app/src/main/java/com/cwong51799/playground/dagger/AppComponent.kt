package com.cwong51799.playground.dagger

import android.app.Application
import com.cwong51799.playground.App
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dagger.android.support.AndroidSupportInjectionModule

@Component(modules = [AndroidSupportInjectionModule::class, AppModule::class])
interface AppComponent : AndroidInjector<App> {
    @Component.Builder
    interface Builder {
        fun build() : AppComponent
        @BindsInstance
        fun application(app: App): Builder
    }
}
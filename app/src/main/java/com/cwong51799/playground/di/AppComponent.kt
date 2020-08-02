package com.cwong51799.playground.di

import com.cwong51799.playground.App
import dagger.Component

@Component(modules = [AppModule::class])
interface AppComponent {
    fun inject(app: App)
}
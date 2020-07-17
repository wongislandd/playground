package com.cwong51799.playground

import android.app.Application
import com.cwong51799.playground.APITester.DaggerAPITesterComponent

interface PlaygroundAppComponent { }


class MyApplication : Application() {
    val appComponent = DaggerAPITesterComponent.create()
}
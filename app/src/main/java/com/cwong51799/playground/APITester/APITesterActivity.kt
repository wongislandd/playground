package com.cwong51799.playground.APITester

import android.app.Activity
import android.os.Bundle
import com.cwong51799.playground.MyApplication
import javax.inject.Inject

class APITesterActivity : Activity() {
    @Inject
    lateinit var APITesterViewModel : APITesterViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        (applicationContext as MyApplication)
        super.onCreate(savedInstanceState)
    }
}
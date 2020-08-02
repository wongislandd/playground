package com.cwong51799.api

import android.os.Bundle
import com.cwong51799.core.CoreUtilities
import dagger.android.support.DaggerAppCompatActivity

class APIActivity : DaggerAppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_api)
    }
}

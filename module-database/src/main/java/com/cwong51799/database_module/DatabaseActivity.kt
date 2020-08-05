package com.cwong51799.database_module

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class DatabaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTitle(R.string.database_tester_title)
        setContentView(R.layout.activity_database)
    }
}

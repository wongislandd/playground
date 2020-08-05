package com.cwong51799.module_hajime

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class HajimeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTitle(R.string.hajime_module_title)
        setContentView(R.layout.activity_hajime)
    }
}

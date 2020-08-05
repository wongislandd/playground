package com.cwong51799.core

import androidx.navigation.NavOptions

object CoreUtilities {
    fun getNavOptions() : NavOptions {
        val options : NavOptions = NavOptions.Builder()
            .setEnterAnim(R.anim.nav_slide_out)
            .setExitAnim(R.anim.nav_slide_in)
            .setPopEnterAnim(R.anim.nav_slide_in)
            .setPopExitAnim(R.anim.nav_slide_out)
            .build()
        return options
    }
}
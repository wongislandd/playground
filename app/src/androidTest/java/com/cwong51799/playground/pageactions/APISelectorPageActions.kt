package com.cwong51799.playground.pageactions

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.withId

object APISelectorPageActions {

    // The id is dynamically set to the background resource id
    fun selectApiWithBackgroundResource(backgroundResource : Int) {
        onView(withId(backgroundResource)).perform(click())
    }


}
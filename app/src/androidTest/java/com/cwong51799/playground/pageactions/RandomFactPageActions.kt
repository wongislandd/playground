package com.cwong51799.playground.pageactions

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import com.cwong51799.playground.R
import java.lang.Thread.sleep

object RandomFactPageActions {
    fun getARandomFactAndCheckForDisplay(){
        onView(withId(R.id.newFactBtn)).perform(click())
        sleep(1000)
        onView(withId(R.id.factTextTV)).check(matches(isDisplayed()))
    }
}
package com.cwong51799.playground.pageactions

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.matcher.ViewMatchers
import com.cwong51799.playground.utils.ModuleUtils

object ModuleSelectorPageActions {
    fun selectModule(moduleName : String) {
        onView(ViewMatchers.withText(moduleName)).perform(ViewActions.click())
    }

}
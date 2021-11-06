package com.cwong51799.playground

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.cwong51799.api.APIActivity
import com.cwong51799.api.utils.APIUtils
import com.cwong51799.playground.pageactions.APISelectorPageActions
import com.cwong51799.playground.pageactions.ModuleSelectorPageActions
import com.cwong51799.playground.pageactions.RandomFactPageActions
import com.cwong51799.playground.utils.ModuleUtils
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class RandomFactTest(){
    @get:Rule
    var activityTestRule = ActivityTestRule(APIActivity::class.java)

    @Test
    fun getAFact(){
        ModuleSelectorPageActions.selectModule(ModuleUtils.API_MODULE.name)
        APISelectorPageActions.selectApiWithBackgroundResource(APIUtils.RANDOM_FACT_API.backgroundResource)
        RandomFactPageActions.getARandomFactAndCheckForDisplay()
        RandomFactPageActions.getARandomFactAndCheckForDisplay()
        RandomFactPageActions.getARandomFactAndCheckForDisplay()
    }
}
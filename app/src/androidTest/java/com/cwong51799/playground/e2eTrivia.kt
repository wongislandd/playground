package com.cwong51799.playground

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.cwong51799.api.APIActivity
import com.cwong51799.api.utils.APIUtils
import com.cwong51799.playground.pageactions.APISelectorPageActions
import com.cwong51799.playground.pageactions.ModuleSelectorPageActions
import com.cwong51799.playground.pageactions.TriviaPageActions
import com.cwong51799.playground.utils.ModuleUtils
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.lang.Thread.sleep


@RunWith(AndroidJUnit4::class)
class TriviaTest(){

    /**
     * Launch the API Activity module
     */
    @get:Rule
    var activityTestRule = ActivityTestRule(APIActivity::class.java)

    /**
     * An end to end test of trivia.
     */
    @Test
    fun playTrivia() {
        ModuleSelectorPageActions.selectModule(ModuleUtils.APIModule.name)
        APISelectorPageActions.selectApiWithBackgroundResource(APIUtils.TRIVIA_API.backgroundResource)
        TriviaPageActions.clickBeginTrivia()
        TriviaPageActions.waitForTriviaToLoad()
        while(!TriviaPageActions.onTriviaOptionsPage()) {
            TriviaPageActions.selectTriviaOption()
            TriviaPageActions.clickLockInAnswer()
            TriviaPageActions.clickNextQuestion()
        }
    }
}
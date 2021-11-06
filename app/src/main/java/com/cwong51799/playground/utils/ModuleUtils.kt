package com.cwong51799.playground.utils

import com.cwong51799.api.APIActivity
import com.cwong51799.database_module.DatabaseActivity
//import com.cwong51799.module_hajime.HajimeActivity
import com.cwong51799.playground.R

data class Module (val name : String, val activityClass : Class<out Any>, val backgroundResource : Int)


/**
 * Contains the information needed to load each module in ModuleSelectorFragment
 */
object ModuleUtils {
    val API_MODULE = Module("API Tester", APIActivity::class.java, R.drawable.flower_background)
    val DATABASE_MODULE = Module("Database Tester", DatabaseActivity::class.java, R.drawable.database_background)
    val moduleList = listOf(
        API_MODULE, DATABASE_MODULE
    )
}


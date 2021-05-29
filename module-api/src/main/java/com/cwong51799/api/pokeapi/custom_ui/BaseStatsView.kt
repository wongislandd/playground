package com.cwong51799.api.pokeapi.custom_ui

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.GridLayout
import android.widget.ProgressBar
import com.cwong51799.api.R

class BaseStatsView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null
) : GridLayout(context, attrs) {

    private var hpBar : ProgressBar
    private var atkBar : ProgressBar
    private var defBar : ProgressBar
    private var spAtkBar : ProgressBar
    private var spDefBar : ProgressBar
    private var spdBar : ProgressBar


    init {
        LayoutInflater.from(context).inflate(R.layout.base_stats_display, this, true)
        hpBar = findViewById(R.id.hpBar)
        atkBar = findViewById(R.id.atkBar)
        defBar = findViewById(R.id.defBar)
        spAtkBar = findViewById(R.id.spAtkBar)
        spDefBar = findViewById(R.id.spDefBar)
        spdBar = findViewById(R.id.spdBar)
    }

    fun setStats(stats : List<Int>) {
        hpBar.progress = getStatPercentageAsInt(stats[0])
        atkBar.progress = getStatPercentageAsInt(stats[1])
        defBar.progress = getStatPercentageAsInt(stats[2])
        spAtkBar.progress = getStatPercentageAsInt(stats[3])
        spDefBar.progress = getStatPercentageAsInt(stats[4])
        spdBar.progress = getStatPercentageAsInt(stats[5])
    }


    private fun getStatPercentageAsInt(stat : Int) : Int {
        return ((stat.toDouble() / MAX_STAT) * 100).toInt()
    }

    companion object {
        const val MAX_STAT = 300
    }

}
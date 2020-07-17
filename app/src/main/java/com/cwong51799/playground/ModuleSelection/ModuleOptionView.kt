package com.cwong51799.playground.ModuleSelection

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import com.cwong51799.playground.R
import kotlinx.android.synthetic.main.module_option_view.view.*

class ModuleOptionView @JvmOverloads constructor(
    context : Context,
    backgroundResource : Int,
    moduleName : String,
    attrs : AttributeSet? = null
    ) : ConstraintLayout(context, attrs) {

    init{
        LayoutInflater.from(context).inflate(R.layout.module_option_view, this, true)
        moduleOptionParentView.setBackgroundResource(backgroundResource)
        moduleOptionNameTV.text = moduleName
    }


}
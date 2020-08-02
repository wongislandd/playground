package com.cwong51799.playground.module_selection

import android.content.Context
import android.content.Intent
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat.startActivity
import com.cwong51799.playground.R
import kotlinx.android.synthetic.main.module_option_view.view.*


/**
 * A custom view associated with launching an individual module
 */
class ModuleOptionView @JvmOverloads constructor(
    moduleName : String,
    moduleClass : Class<out Any>,
    context : Context,
    backgroundResource : Int,
    attrs : AttributeSet? = null
    ) : ConstraintLayout(context, attrs) {

    init{
        LayoutInflater.from(context).inflate(R.layout.module_option_view, this, true)
        moduleOptionParentView.setBackgroundResource(backgroundResource)
        moduleOptionNameTV.text = moduleName
        moduleOptionParentView.setOnClickListener{startActivity(context, Intent(context,moduleClass), null)}
    }
}
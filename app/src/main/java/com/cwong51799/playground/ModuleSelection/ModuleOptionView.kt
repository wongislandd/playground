package com.cwong51799.playground.ModuleSelection

import android.content.Context
import android.content.Intent
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat.startActivity
import com.cwong51799.playground.R
import kotlinx.android.synthetic.main.module_option_view.view.*

class ModuleOptionView @JvmOverloads constructor(
    module : Class<out Any>,
    context : Context,
    backgroundResource : Int,
    attrs : AttributeSet? = null
    ) : ConstraintLayout(context, attrs) {

    init{
        LayoutInflater.from(context).inflate(R.layout.module_option_view, this, true)
        moduleOptionParentView.setBackgroundResource(backgroundResource)
    }
}
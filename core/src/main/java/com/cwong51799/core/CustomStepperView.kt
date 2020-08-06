package com.cwong51799.core

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import kotlinx.android.synthetic.main.custom_stepper_view.view.*

class CustomStepperView @JvmOverloads constructor(
    context : Context,
    attrs : AttributeSet? = null
) : ConstraintLayout(context, attrs) {

    init{
        LayoutInflater.from(context).inflate(R.layout.custom_stepper_view,this, true)
        minusStep.setOnClickListener { decrementCount() }
        plusStep.setOnClickListener { incrementCount() }
    }


    fun getCount() : Int{
        return Integer.parseInt(stepperCount.text.toString())
    }

    private fun incrementCount(){
        val currentCount = Integer.parseInt(stepperCount.text.toString())
        stepperCount.setText((currentCount+1).toString())
    }
    private fun decrementCount(){
        val currentCount = Integer.parseInt(stepperCount.text.toString())
        stepperCount.setText((currentCount-1).toString())
    }
}
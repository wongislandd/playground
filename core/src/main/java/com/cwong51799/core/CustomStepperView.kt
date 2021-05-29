package com.cwong51799.core

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.LayoutInflater
import android.view.MotionEvent
import androidx.constraintlayout.widget.ConstraintLayout
import kotlinx.android.synthetic.main.custom_stepper_view.view.*

class CustomStepperView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null
) : ConstraintLayout(context, attrs) {

    private var minCount = MIN_QUESTION_COUNT
    private var maxCount = MAX_QUESTION_COUNT

    init {
        LayoutInflater.from(context).inflate(R.layout.custom_stepper_view, this, true)
        minusStep.setOnClickListener {
            decrementCount()
            callOnClick()
        }
        plusStep.setOnClickListener {
            incrementCount()
            callOnClick()
        }
    }

    fun setCount(count : Int){
        stepperCount.setText(count.toString())
    }

    fun getCount(): Int {
        return Integer.parseInt(stepperCount.text.toString())
    }

    private fun incrementCount() {
        val currentCount = getCount()
        if (currentCount < maxCount)
            stepperCount.setText((currentCount + 1).toString())
    }

    private fun decrementCount() {
        val currentCount = getCount()
        if (currentCount > minCount)
            stepperCount.setText((currentCount - 1).toString())
    }

    fun setStepperMinMax(min : Int, max : Int) {
        minCount = min
        maxCount = max
    }

    companion object {
        private const val MIN_QUESTION_COUNT = 1
        private const val MAX_QUESTION_COUNT = 100
    }
}
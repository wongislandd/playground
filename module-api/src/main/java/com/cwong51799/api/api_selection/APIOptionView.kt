package com.cwong51799.api.api_selection

import android.content.Context
import android.content.Intent
import android.util.AttributeSet
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import com.cwong51799.api.R
import com.cwong51799.api.utils.API
import kotlinx.android.synthetic.main.api_option_view.view.*


/**
 * A custom view representing an API to enter
 */
class APIOptionView @JvmOverloads constructor(
    associatedApi : API,
    context : Context,
    attrs : AttributeSet? = null
) : ConstraintLayout(context, attrs) {

    init{
        LayoutInflater.from(context).inflate(R.layout.api_option_view, this, true)
        // Set Id to the background resource to be found in Espresso tests
        this.id = associatedApi.backgroundResource
        apiOptionParentView.setBackgroundResource(associatedApi.backgroundResource)
        apiOptionNameTV.visibility = View.GONE
    }
}
package com.cwong51799.playground.ModuleSelection

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import com.cwong51799.playground.R


class ModuleSelectorFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_module_selector, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        // Create a LinearLayout element
        val selectionView = view.findViewById<LinearLayout>(R.id.selectionView)
        // Add Buttons
        for (x in 0 .. 5) {
            selectionView.addView(
                ModuleOptionView(
                    view.context,
                    R.drawable.sparkle_background,
                    "Module $x"
                )
            )
        }
        // Add the LinearLayout element to the ScrollView
        super.onViewCreated(view, savedInstanceState)
    }
}
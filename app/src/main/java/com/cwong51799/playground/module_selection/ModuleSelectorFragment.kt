package com.cwong51799.playground.module_selection

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import com.cwong51799.playground.R
import com.cwong51799.playground.utils.ModuleUtils


class ModuleSelectorFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_module_selector, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val selectionView = view.findViewById<LinearLayout>(R.id.moduleSelectionLinearLayout)
        // Generate a new module view for each module
        for (module in ModuleUtils.moduleList) {
            selectionView.addView(
                ModuleOptionView(
                    moduleName = module.name,
                    moduleClass = module.activityClass,
                    backgroundResource = module.backgroundResource,
                    context = view.context
                )
            )
        }
        super.onViewCreated(view, savedInstanceState)
    }
}
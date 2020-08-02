package com.cwong51799.api.api_selection

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.cwong51799.api.R
import com.cwong51799.api.utils.APIUtils

class APISelectorFragment : Fragment() {

    companion object {
        fun newInstance() =
            APISelectorFragment()
    }

    private lateinit var viewModel: APISelectorViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.selector_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val selectionView = view.findViewById<LinearLayout>(R.id.apiSelectorSV)
        // Generate a new module view for each module
        for (api in APIUtils.apiList) {
            selectionView.addView(
                APIOptionView(
                    associatedApi = api,
                    context = view.context
                )
            )
        }
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(APISelectorViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
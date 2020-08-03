package com.cwong51799.api.api_selection

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.lifecycle.observe
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.cwong51799.api.R
import com.cwong51799.api.utils.API
import com.cwong51799.api.utils.APIViewModel
import com.cwong51799.api.utils.APIUtils

class APISelectorFragment : Fragment() {
    private lateinit var viewModel: APIViewModel
    private lateinit var navController : NavController
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProviders.of(this).get(APIViewModel::class.java)
        navController = NavHostFragment.findNavController(this)
        return inflater.inflate(R.layout.fragment_selector, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val selectionView = view.findViewById<LinearLayout>(R.id.apiSelectorSV)
        // Generate a new module view for each module
        for (api in APIUtils.apiList) {
            val newOptionView = APIOptionView(
                associatedApi = api,
                context = view.context
            )
            newOptionView.setOnClickListener{
                viewModel.select(api)
            }
            selectionView.addView(newOptionView)
        }
        // Subscribe to a change in the selected API
        viewModel.selectedAPI.observe(viewLifecycleOwner) {
            if (it != null) {
                goToAPI(it)
                viewModel.resetSelected()
            }
        }
        super.onViewCreated(view, savedInstanceState)
    }

    fun goToAPI(api : API) {
        val nextScreen = when(api.name) {
            APIUtils.PokeAPIName -> R.id.pokeAPI
            APIUtils.RandomFactAPIName -> R.id.randomFactAPI
            else -> R.id.pokeAPI
        }
        navController.navigate(nextScreen)
    }


    companion object {
        private const val TAG = "APISelectorFragment"
    }

}
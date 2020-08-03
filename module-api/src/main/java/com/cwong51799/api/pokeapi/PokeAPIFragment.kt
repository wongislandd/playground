package com.cwong51799.api.pokeapi

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavController
import com.cwong51799.api.R
import com.cwong51799.api.api_selection.APISelectorViewModel
import kotlinx.android.synthetic.main.fragment_poke_api.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [PokeAPI.newInstance] factory method to
 * create an instance of this fragment.
 */
class PokeAPIFragment : Fragment() {
    private lateinit var viewModel: PokeAPIViewModel
    private lateinit var navController : NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        viewModel = ViewModelProviders.of(this).get(PokeAPIViewModel::class.java)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        querySender.setOnClickListener{

        }
        return inflater.inflate(R.layout.fragment_poke_api, container, false)
    }

    companion object {
        private val TAG = "PokeAPIFragment"
    }
}
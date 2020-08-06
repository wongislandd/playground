package com.cwong51799.api.pokeapi

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.cwong51799.api.R
import com.cwong51799.api.utils.APIViewModel

/**
 * A simple [Fragment] subclass.
 * Use the [PokeAPI.newInstance] factory method to
 * create an instance of this fragment.
 */
class PokeAPIFragment : Fragment() {
    private lateinit var viewModel: APIViewModel
    private lateinit var navController : NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        viewModel = ViewModelProviders.of(this).get(APIViewModel::class.java)
        navController = NavHostFragment.findNavController(this)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_poke_api, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val querySender = view.findViewById<Button>(R.id.querySender)
        val queryResult = view.findViewById<TextView>(R.id.queryResult)
        super.onViewCreated(view, savedInstanceState)
    }

    companion object {
        private val TAG = "PokeAPIFragment"
    }
}
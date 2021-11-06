package com.cwong51799.api.randomfactapi.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.observe
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.cwong51799.api.R
import com.cwong51799.api.randomfactapi.network.FactResponse
import com.cwong51799.api.randomfactapi.network.RandomFactServices
import com.cwong51799.api.randomfactapi.viewmodels.RandomFactViewModel
import com.cwong51799.api.utils.APIUtils
import retrofit2.*
import retrofit2.converter.moshi.MoshiConverterFactory

/**
 * A simple [Fragment] subclass.
 * Use the [RandomFactFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class RandomFactFragment : Fragment() {
    private lateinit var viewModel: RandomFactViewModel
    private lateinit var navController : NavController

    private lateinit var factText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        viewModel = ViewModelProviders.of(this).get(RandomFactViewModel::class.java)
        navController = NavHostFragment.findNavController(this)
        viewModel.getNewFact()
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_random_fact, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        factText = view.findViewById(R.id.factTextTV)
        viewModel.currentFact.observe(viewLifecycleOwner) { fact ->
            setFactText(fact)
        }
        viewModel.errorMessage.observe(viewLifecycleOwner) { error ->
            setFactText(error)
        }
        val factFinder = view.findViewById<Button>(R.id.newFactBtn)

        factFinder.setOnClickListener {
            viewModel.getNewFact()
        }
        super.onViewCreated(view, savedInstanceState)
    }

    private fun setFactText(fact: String) {
        factText.text = fact
        factText.visibility = if (fact.isNotEmpty()) View.VISIBLE else View.INVISIBLE
    }

}
package com.cwong51799.api.randomfactapi.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import retrofit2.converter.moshi.MoshiConverterFactory
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.observe
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.cwong51799.api.R
import com.cwong51799.api.randomfactapi.viewmodels.RandomFactViewModel
import com.cwong51799.api.randomfactapi.network.FactResponse
import com.cwong51799.api.randomfactapi.network.RandomFactServices
import com.cwong51799.api.utils.APIUtils
import retrofit2.*

/**
 * A simple [Fragment] subclass.
 * Use the [RandomFactFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class RandomFactFragment : Fragment() {
    private lateinit var viewModel: RandomFactViewModel
    private lateinit var navController : NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        viewModel = ViewModelProviders.of(this).get(RandomFactViewModel::class.java)
        navController = NavHostFragment.findNavController(this)
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
        val factText = view.findViewById<TextView>(R.id.factTextTV)
        viewModel.currentFact.observe(viewLifecycleOwner) {
            factText.text = it
            factText.visibility = if (it != emptyResponseBodyStr) View.VISIBLE else View.INVISIBLE
        }
        val factFinder = view.findViewById<Button>(R.id.newFactBtn)
        val retrofit = Retrofit.Builder().baseUrl(APIUtils.RANDOM_FACT_API.baseUrl).addConverterFactory(MoshiConverterFactory.create()).build()
        val FactApi = retrofit.create(RandomFactServices::class.java)
        factFinder.setOnClickListener {
            val call = FactApi.getFact()
            call.enqueue(object : Callback<FactResponse> {
                override fun onFailure(call: Call<FactResponse>, t: Throwable) {
                    factText.text = t.message
                }

                override fun onResponse(call: Call<FactResponse>, response: Response<FactResponse>) {
                    if(!response.isSuccessful){
                        factText.text = "Code: " + response.code()
                        return
                    }
                    viewModel.changeCurrentFact(response.body()?.text ?: emptyResponseBodyStr)
                }
            })
        }
        super.onViewCreated(view, savedInstanceState)
    }

    companion object {
        const val emptyResponseBodyStr = "Response body empty."
    }
}
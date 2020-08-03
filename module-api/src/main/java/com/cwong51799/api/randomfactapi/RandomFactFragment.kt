package com.cwong51799.api.randomfactapi

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import retrofit2.converter.moshi.MoshiConverterFactory
import android.widget.Button
import android.widget.TextView
import com.cwong51799.api.R
import com.squareup.moshi.Moshi
import retrofit2.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [RandomFactFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class RandomFactFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
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
        val factFinder = view.findViewById<Button>(R.id.factFinderBtn)
        val retrofit = Retrofit.Builder().baseUrl("https://uselessfacts.jsph.pl/").addConverterFactory(MoshiConverterFactory.create()).build()
        val factAPI = retrofit.create(RandomFactServices::class.java)
        factFinder.setOnClickListener {
            val call = factAPI.getFact()
            call.enqueue(object : Callback<Fact> {
                override fun onFailure(call: Call<Fact>, t: Throwable) {
                    factText.text = t.message
                }

                override fun onResponse(call: Call<Fact>, response: Response<Fact>) {
                    if(!response.isSuccessful){
                        factText.text = "Code: " + response.code()
                        return
                    }
                    factText.text = response.body()?.text ?: "Null"
                }
            })
        }
        super.onViewCreated(view, savedInstanceState)
    }

    companion object {

    }
}
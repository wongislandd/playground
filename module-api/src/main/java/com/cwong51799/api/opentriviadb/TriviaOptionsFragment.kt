package com.cwong51799.api.opentriviadb

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.cwong51799.api.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [TriviaOptionsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class TriviaOptionsFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_trivia_options, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        //val categorySelector
        super.onViewCreated(view, savedInstanceState)
    }
}
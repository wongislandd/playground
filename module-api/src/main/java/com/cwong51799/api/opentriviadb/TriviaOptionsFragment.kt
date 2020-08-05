package com.cwong51799.api.opentriviadb

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.cwong51799.api.R
import com.cwong51799.api.opentriviadb.triviautils.TriviaSettings
import com.cwong51799.api.opentriviadb.triviautils.TriviaUtils
import java.lang.Integer.parseInt


/**
 * A simple [Fragment] subclass.
 * Use the [TriviaOptionsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class TriviaOptionsFragment : Fragment() {

    lateinit var viewModel : TriviaViewModel
    lateinit var navController : NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        viewModel = ViewModelProviders.of(requireActivity()).get(TriviaViewModel::class.java)
        navController = NavHostFragment.findNavController(this)
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
        viewModel.resetTrivia()
        val numQuestionsSelector = view.findViewById<EditText>(R.id.numberQuestionsEditText)
        val categorySelector = view.findViewById<Spinner>(R.id.categorySelectorSpinner)
        val difficultySelector = view.findViewById<Spinner>(R.id.difficultySelectorSpinner)
        val startTriviaBtn = view.findViewById<Button>(R.id.startTriviaBtn)

        startTriviaBtn.setOnClickListener {
            val numQuestions = numQuestionsSelector.text.toString()
            viewModel.queryTrivia(TriviaSettings(
                numQuestions = if (numQuestions.isNotEmpty()) parseInt(numQuestionsSelector.text.toString()) else DEFAULT_NUM_QUESTIONS,
                category = TriviaUtils.getIndexOfCategory(categorySelector.selectedItem.toString()),
                difficulty = difficultySelector.selectedItem.toString().toLowerCase()
            ))
            navigateToTrivia()
        }
        super.onViewCreated(view, savedInstanceState)
    }

    /**
     * Navigate to the main trivia fragment
     */
    private fun navigateToTrivia(){
        navController.navigate(R.id.triviaMainFragment)
    }

    companion object{
        private const val DEFAULT_NUM_QUESTIONS = 1
    }
}
package com.cwong51799.api.opentriviadb

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.cwong51799.api.R

class PostQuestionFragment  : Fragment() {
    private lateinit var viewModel: TriviaViewModel
    private lateinit var navController : NavController


    override fun onCreate(savedInstanceState: Bundle?) {
        viewModel = ViewModelProviders.of(this).get(TriviaViewModel::class.java)
        navController = NavHostFragment.findNavController(this)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_post_question, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setAnswerStatus(view)
        setTriviaQuestion(view)
        setCorrectAnswer(view)
        setScore(view)
        super.onViewCreated(view, savedInstanceState)
    }

    fun setAnswerStatus(view : View){
        val answerStatusTV = view.findViewById<TextView>(R.id.answerStatusTV)
        if(viewModel.isSelectedAnswerCorrect()){
            answerStatusTV.text = "CORRECT"
            viewModel.numCorrect++
        } else {
            answerStatusTV.text = "INCORRECT"
            viewModel.numIncorrect++
        }
    }

    fun setTriviaQuestion(view : View) {
        val triviaQuestionTV = view.findViewById<TextView>(R.id.triviaQuestionTV)
        triviaQuestionTV.text = viewModel.currentQuestion.value?.question
    }

    fun setCorrectAnswer(view : View) {
        val correctAnswerTV = view.findViewById<TextView>(R.id.correctAnswerTV)
        correctAnswerTV.text = viewModel.selectedAnswer.value?.first
    }

    fun setScore(view : View){
        val numCorrectTV = view.findViewById<TextView>(R.id.numCorrectTV)
        val numIncorrectTV = view.findViewById<TextView>(R.id.numIncorrectTV)
        numCorrectTV.text = viewModel.numCorrect.toString()
        numIncorrectTV.text = viewModel.numIncorrect.toString()
    }

    companion object {

    }
}
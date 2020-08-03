package com.cwong51799.api.opentriviadb

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ScrollView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.observe
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.cwong51799.api.R
import com.cwong51799.api.api_selection.APIOptionView
import com.cwong51799.api.randomfactapi.RandomFactFragment
import com.cwong51799.api.randomfactapi.RandomFactServices
import com.cwong51799.api.utils.APIUtils
import kotlinx.android.synthetic.main.fragment_trivia_api.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory


class TriviaFragment : Fragment() {
    private lateinit var viewModel: TriviaViewModel
    private lateinit var navController : NavController
    private lateinit var triviaQuestionTV : TextView
    private lateinit var triviaOptionsTV : ScrollView

    override fun onCreate(savedInstanceState: Bundle?) {
        viewModel = ViewModelProviders.of(this).get(TriviaViewModel::class.java)
        navController = NavHostFragment.findNavController(this)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_trivia_api, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        triviaQuestionTV = view.findViewById<TextView>(R.id.triviaQuestionTV)
        triviaOptionsTV = view.findViewById<ScrollView>(R.id.triviaOptionsSV)

        viewModel.currentQuestion.observe(viewLifecycleOwner) { triviaResult ->
            generateTriviaQuestion(view, triviaResult)
        }


        val retrofit = Retrofit.Builder().baseUrl(APIUtils.TRIVIA_API_BASE_URL).addConverterFactory(
            MoshiConverterFactory.create()).build()
        val TriviaApi = retrofit.create(TriviaServices::class.java)
        val call = TriviaApi.getAQuestion(1)

        call.enqueue(object : Callback<TriviaResponse> {
            override fun onFailure(call: Call<TriviaResponse>, t: Throwable) {
                Toast.makeText(view.context, "Something went wrong!", Toast.LENGTH_LONG)
            }

            override fun onResponse(
                call: Call<TriviaResponse>,
                response: Response<TriviaResponse>
            ) {
                viewModel.currentQuestion.value = response.body()?.triviaResults?.first()
            }
        })
        super.onViewCreated(view, savedInstanceState)
    }

    fun generateTriviaQuestion(view : View, result : TriviaResult) {
        triviaQuestionTV.text = result.question
        val possibleAnswers = mutableListOf<Pair<String, Boolean>>()
        result.incorrect_answers.forEach {
            possibleAnswers.add(Pair(it, false))
        }
        possibleAnswers.add(Pair(result.correct_answer,true))
        possibleAnswers.shuffle()
        for (answer in possibleAnswers) {
            val newOptionView = TriviaAnswerView(
                answerText = answer.first,
                correct = answer.second,
                context = view.context
            )
            newOptionView.setOnClickListener {
                if(isCorrect(answer)) {
                    // go to correct page
                } else {
                    // go to incorrect page
                }
            }
        }

    }

    fun isCorrect(answer : Pair<String, Boolean>) : Boolean{
        return answer.second
    }

    companion object {
    }
}
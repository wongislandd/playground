package com.cwong51799.api.opentriviadb

import android.opengl.Visibility
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.text.HtmlCompat
import androidx.core.view.children
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.observe
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.cwong51799.api.R
import com.cwong51799.api.opentriviadb.triviautils.TriviaUtils
import com.cwong51799.api.utils.APIUtils
import kotlinx.android.synthetic.main.trivia_answer_view.view.*
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
    private lateinit var triviaOptionsLL : LinearLayout
    private lateinit var triviaLockAnswerBtn : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        viewModel = ViewModelProviders.of(requireActivity()).get(TriviaViewModel::class.java)
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
        triviaQuestionTV = view.findViewById(R.id.triviaQuestionTV)
        triviaOptionsTV = view.findViewById(R.id.triviaOptionsSV)
        triviaOptionsLL = view.findViewById(R.id.triviaOptionLL)
        triviaLockAnswerBtn = view.findViewById(R.id.triviaLockAnswerBtn)


        val retrofit = Retrofit.Builder().baseUrl(APIUtils.TRIVIA_API_BASE_URL).addConverterFactory(
            MoshiConverterFactory.create()).build()
        val TriviaApi = retrofit.create(TriviaServices::class.java)
        val call = TriviaApi.getAQuestion(1)


        viewModel.currentQuestion.observe(viewLifecycleOwner) { currentQuestion ->
            if(currentQuestion != null) {
                generateTriviaQuestion(view, currentQuestion)
            }
        }

        viewModel.selectedAnswer.observe(viewLifecycleOwner) {selectedAnswer ->
            if(selectedAnswer != null) {
                triviaLockAnswerBtn.text = "LOCK IN " + selectedAnswer.first
                triviaLockAnswerBtn.isEnabled = true
            }
        }

        triviaLockAnswerBtn.setOnClickListener {
            navigateToPostQuestion()
        }

        call.enqueue(object : Callback<TriviaResponse> {
            override fun onFailure(call: Call<TriviaResponse>, t: Throwable) {
                Toast.makeText(view.context, "Something went wrong!", Toast.LENGTH_LONG)
            }

            override fun onResponse(
                call: Call<TriviaResponse>,
                response: Response<TriviaResponse>
            ) {
                viewModel.currentQuestion.value = response.body()?.results?.first()
            }
        })

        super.onViewCreated(view, savedInstanceState)
    }

    fun generateTriviaQuestion(view : View, result : TriviaResult?) {
        if(result != null) {
            triviaOptionsLL.removeAllViews()
            triviaQuestionTV.text = HtmlCompat.fromHtml(
                TriviaUtils.formatToHtml(result.question),
                HtmlCompat.FROM_HTML_MODE_LEGACY
            )
            val possibleAnswers = mutableListOf<Pair<String, Boolean>>()
            result.incorrect_answers.forEach {
                possibleAnswers.add(Pair(it, false))
            }
            possibleAnswers.add(Pair(result.correct_answer, true))
            possibleAnswers.shuffle()
            for (answer in possibleAnswers) {
                val newOptionView = TriviaAnswerView(
                    answerText = answer.first,
                    correct = answer.second,
                    context = view.context
                )
                newOptionView.setOnClickListener {
                    deselectAllButtons()
                    newOptionView.selectAnswer()
                    viewModel.selectedAnswer.value = answer
                }
                triviaOptionsLL.addView(newOptionView)
            }
        }
    }

    fun navigateToPostQuestion() {
        navController.navigate(R.id.post_question)
    }

    /**
     * Deselects all buttons in the option scroll view
     */
    fun deselectAllButtons() {
        for (view in triviaOptionsLL.children) {
            if (view is TriviaAnswerView) {
                view.deselectAnswer()
            }
        }
    }

    companion object {
    }
}
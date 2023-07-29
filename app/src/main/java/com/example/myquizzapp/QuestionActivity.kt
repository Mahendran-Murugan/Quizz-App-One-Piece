package com.example.myquizzapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.graphics.drawable.AdaptiveIconDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.core.content.ContextCompat

class QuestionActivity : AppCompatActivity(), View.OnClickListener {
    private var mCurrentPosition : Int? = 1
    private var mQuestionList : ArrayList<Question>? = null
    private var mSelectedOption : Int? = 0
    private var mUserName : String? = null
    private var mCorrectAnswer : Int = 0
    private var progressbar : ProgressBar? = null
    private var tvProgressbar : TextView? = null
    private var imageView : ImageView? = null
    private var quesTxt : TextView? = null
    private var option1 : TextView? = null
    private var option2 : TextView? = null
    private var option3 : TextView? = null
    private var option4 : TextView? = null
    private var btnSubmit2 : Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)
        progressbar = findViewById(R.id.progressbar)
        tvProgressbar = findViewById(R.id.tv_progress)
        imageView = findViewById(R.id.iv1)
        quesTxt = findViewById(R.id.tv_question)
        option1 = findViewById(R.id.tv_optionOne)
        option2 = findViewById(R.id.tv_optionTwo)
        option3 = findViewById(R.id.tv_optionThree)
        option4 = findViewById(R.id.tv_optionFour)
        btnSubmit2 = findViewById(R.id.btnSubmit2)
        mQuestionList = Constants.getQuestion()
        mUserName = intent.getStringExtra(Constants.tv_usr_name)
        setQuestions()
        defaultOptionView()
        option1?.setOnClickListener(this)
        option2?.setOnClickListener(this)
        option3?.setOnClickListener(this)
        option4?.setOnClickListener(this)
        btnSubmit2?.setOnClickListener(this)

    }

    private fun setQuestions() {
        defaultOptionView()
        val question: Question = mQuestionList!![mCurrentPosition!! - 1]
        progressbar?.progress = mCurrentPosition!!
        tvProgressbar?.text = "$mCurrentPosition/4"
        imageView?.setImageResource(question.image)
        quesTxt?.text = question.question
        option1?.text = question.OptionOne
        option2?.text = question.OptionTwo
        option3?.text = question.OptionThree
        option4?.text = question.OptionFour
        if(mCurrentPosition == mQuestionList!!.size){
             btnSubmit2?.text = "Finish"
        }else{
            btnSubmit2?.text = "Submit"
        }
    }
    private fun selectedOptionView(tv : TextView, selectedOption : Int){
        defaultOptionView()
        mSelectedOption = selectedOption
        tv.setTypeface(tv.typeface,Typeface.BOLD)
        tv.background =ContextCompat.getDrawable(
            this,
            R.drawable.selected_border_bg
        )
    }
    private fun defaultOptionView(){
        val options = ArrayList<TextView>()
        option1?.let{
            options.add(0,it)
        }
        option2?.let{
            options.add(1,it)
        }
        option3?.let{
            options.add(2,it)
        }
        option4?.let{
            options.add(3,it)
        }
        for(option in options){
            option.setTextColor(Color.parseColor("#808080"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                this,
                R.drawable.option_border_bg
            )
        }
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.tv_optionOne ->{
                option1?.let {
                    selectedOptionView(it,1)
                    it.setTextColor(Color.parseColor("#000000"))
                }
            }
            R.id.tv_optionTwo ->{
                option2?.let {
                    selectedOptionView(it,2)
                    it.setTextColor(Color.parseColor("#000000"))
                }
            }
            R.id.tv_optionThree ->{
                option3?.let {
                    selectedOptionView(it,3)
                    it.setTextColor(Color.parseColor("#000000"))
                }
            }
            R.id.tv_optionFour ->{
                option4?.let {
                    selectedOptionView(it,4)
                    it.setTextColor(Color.parseColor("#000000"))
                }
            }
            R.id.btnSubmit2 ->{
                if(mSelectedOption == 0){
                    mCurrentPosition = mCurrentPosition!!+1
                    when{
                         mCurrentPosition!! <= mQuestionList!!.size ->{
                             setQuestions()
                         }
                        else ->{
                             val intent = Intent(this,ResultActivity::class.java)
                            intent.putExtra(Constants.tv_usr_name,mUserName)
                            intent.putExtra(Constants.correct_answer,mCorrectAnswer.toString())
                            intent.putExtra(Constants.total_question,(mQuestionList?.size).toString())
                            startActivity(intent)
                         }
                    }
                }else{
                    val quest : Question?= mQuestionList!![mCurrentPosition!!-1]
                    if(quest!!.CorrectOption != mSelectedOption){
                        answerView(mSelectedOption!!,R.drawable.wrong_option_border_bg)
                    }else{
                        mCorrectAnswer++
                    }
                    answerView(quest.CorrectOption,R.drawable.correct_option_border_bg)
                    if(mCurrentPosition!! == mQuestionList!!.size){
                        btnSubmit2?.text = "Finish"
                    }else{
                        btnSubmit2?.text = "Next"
                    }
                    mSelectedOption = 0
                }
            }
        }
    }
    private fun answerView(ans : Int, drawableView: Int){
        when(ans){
            1 ->{
                option1?.background=ContextCompat.getDrawable(
                    this,
                    drawableView
                    )
            }
            2 ->{
                option2?.background=ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
            3 ->{
                option3?.background=ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
            4 ->{
                option4  ?.background=ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
        }
    }
}


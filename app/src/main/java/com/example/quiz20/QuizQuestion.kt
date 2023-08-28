package com.example.quiz20

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.*
import androidx.core.content.ContextCompat

class QuizQuestion : AppCompatActivity() , OnClickListener{
    var mCurrentPosition : Int = 1
    var mQuestionList : ArrayList<Question>? = null
    var mSelectedOptionPosition : Int = 0
    var mCorrectAnswers : Int = 0
    var mUsername : String = ""
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_question)

        val option_one = findViewById<TextView>(R.id.tv_option_one)
        val option_two = findViewById<TextView>(R.id.tv_option_two)
        val option_three = findViewById<TextView>(R.id.tv_option_three)
        val option_four = findViewById<TextView>(R.id.tv_option_four)
        val btn = findViewById<Button>(R.id.btn_submit)

        option_one.setOnClickListener(this)
        option_two.setOnClickListener(this)
        option_three.setOnClickListener(this)
        option_four.setOnClickListener(this)
        btn.setOnClickListener(this)

        mUsername = intent.getStringExtra("username").toString()
        mQuestionList = Constant.getQuestion()
        setQuestion()
    }

    private fun setQuestion(){
        val option_one = findViewById<TextView>(R.id.tv_option_one)
        val option_two = findViewById<TextView>(R.id.tv_option_two)
        val option_three = findViewById<TextView>(R.id.tv_option_three)
        val option_four = findViewById<TextView>(R.id.tv_option_four)

        var img = findViewById<ImageView>(R.id.image)
        var btn = findViewById<Button>(R.id.btn_submit)
        var question = mQuestionList!!.get(mCurrentPosition -1)
        defaultQption()

        if(mCurrentPosition == mQuestionList!!.size){
            btn.text="FINISH"
        }else{
            btn.text="SUBMIT"
        }

        var progressBar = findViewById<ProgressBar>(R.id.progress_bar)
        progressBar.progress= mCurrentPosition

        var tvprogress = findViewById<TextView>(R.id.tv_progress)
        tvprogress.text = "$mCurrentPosition"+ "/" + "${progressBar.max}"

        img.setImageResource(question.Image)
        option_one.text = question.q1
        option_two.text = question.q2
        option_three.text = question.q3
        option_four.text = question.q4

    }

    fun defaultQption(){
        val option_one = findViewById<TextView>(R.id.tv_option_one)
        val option_two = findViewById<TextView>(R.id.tv_option_two)
        val option_three = findViewById<TextView>(R.id.tv_option_three)
        val option_four = findViewById<TextView>(R.id.tv_option_four)

        val options = ArrayList<TextView>()
        options.add(option_one)
        options.add(option_two)
        options.add(option_three)
        options.add(option_four)

        for(option in options)
        {
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background= ContextCompat.getDrawable(this, R.drawable.default_option_border_fg)
        }
    }




    private fun selectOptionView(tv : TextView, selectedOtpionNum : Int){
        defaultQption()
        mSelectedOptionPosition = selectedOtpionNum
        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface,Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(this,R.drawable.selected_option_border_bg)
    }

    private fun answerView(anser : Int, drawbleView : Int){
        val option_one = findViewById<TextView>(R.id.tv_option_one)
        val option_two = findViewById<TextView>(R.id.tv_option_two)
        val option_three = findViewById<TextView>(R.id.tv_option_three)
        val option_four = findViewById<TextView>(R.id.tv_option_four)

        when(anser){
            1 ->{
                option_one.background = ContextCompat.getDrawable(this,drawbleView)
            }
            2 ->{
                option_two.background = ContextCompat.getDrawable(this,drawbleView)
            }
            3 ->{
                option_three.background = ContextCompat.getDrawable(this,drawbleView)
            }
            4 ->{
                option_four.background = ContextCompat.getDrawable(this,drawbleView)
            }
        }
    }
    override fun onClick(v: View?) {
        var option_one = findViewById<TextView>(R.id.tv_option_one)
        var option_two = findViewById<TextView>(R.id.tv_option_two)
        var option_three = findViewById<TextView>(R.id.tv_option_three)
        var option_four = findViewById<TextView>(R.id.tv_option_four)
        var btn = findViewById<Button>(R.id.btn_submit)
        when(v?.id){ //when is a switch
            R.id.tv_option_one ->{
                selectOptionView(option_one,1)
            }
            R.id.tv_option_two ->{
                selectOptionView(option_two,2)
            }
            R.id.tv_option_three ->{
                selectOptionView(option_three,3)
            }
            R.id.tv_option_four->{
                selectOptionView(option_four,4)
            }
            R.id.btn_submit ->{ //-> press what happen
                if(mSelectedOptionPosition == 0){
                    mCurrentPosition ++

                    when{
                        mCurrentPosition <= mQuestionList!!.size ->{
                            setQuestion()
                        }else ->{
                        val intent = Intent(this, ResultActivity::class.java)
                        intent.putExtra("username",mUsername)
                        intent.putExtra(Constant.correctans,mCorrectAnswers)
                        intent.putExtra(Constant.totalquestion,mQuestionList!!.size)
                        startActivity(intent)
                        finish()
                    }
                    }
                } else{
                    val question = mQuestionList?.get(mCurrentPosition -1)
                    if(question!!.correctAns!= mSelectedOptionPosition){
                        answerView(mSelectedOptionPosition, R.drawable.wrong_option_border_bg)
                    }else{
                        mCorrectAnswers++
                    }
                    answerView(question.correctAns, R.drawable.correct_option_border_bg)
                    if(mCurrentPosition == mQuestionList!!.size){
                        btn.text = "FINISH"
                    }else{
                        btn.text = "GO TO NEXT QUESTION"
                    }
                    mSelectedOptionPosition = 0
                }
            }
        }
    }
}
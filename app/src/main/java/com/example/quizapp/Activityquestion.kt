package com.example.quizapp

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.SyncStateContract
import android.util.Log
import android.view.View
import android.widget.*
import androidx.core.content.ContextCompat

class Activityquestion : AppCompatActivity(),View.OnClickListener {

    private var currPos: Int=1
    private var GQList:ArrayList<Question>?=null
    private var SelOptPos:Int=0
    private var corrans:Int=0
    private var Username: String?=null

    private var progressBar:ProgressBar?=null
    private var tvprogress:TextView?=null
    private var tvquestion:TextView?=null
//    private var ivimage:ImageView?=null
    private var tvopt1:TextView?=null
    private var tvopt2:TextView?=null
    private var tvopt3:TextView?=null
    private var tvopt4:TextView?=null
    private var btnsubmit:Button?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_activityquestion)
        Username=intent.getStringExtra(questions.USER_NAME)
        progressBar=findViewById(R.id.PB)
        tvprogress=findViewById(R.id.tv_ProgressBar)
        tvquestion=findViewById(R.id.tv_question)
        tvopt1=findViewById(R.id.tv_opt1)
        tvopt2=findViewById(R.id.tv_opt2)
        tvopt3=findViewById(R.id.tv_opt3)
        tvopt4=findViewById(R.id.tv_opt4)
        btnsubmit=findViewById(R.id.btn_submit)
        GQList = questions.getquestion()
        setQuestion()
        tvopt1?.setOnClickListener(this)
        tvopt2?.setOnClickListener(this)
        tvopt3?.setOnClickListener(this)
        tvopt4?.setOnClickListener(this)
        btnsubmit?.setOnClickListener(this)

        //defaultOptionView()


    }
    @SuppressLint("SetTextI18n")
    private fun setQuestion() {
//

        val q: Question = GQList!![currPos- 1]
        defaultOptionView()
        if (currPos == GQList!!.size) {
            btnsubmit?.text = "FINISH"
        } else {
            btnsubmit?.text = "SUBMIT"
        }
        progressBar?.progress = currPos
        tvprogress?.text = "$currPos" + "/" + progressBar?.max
        tvquestion?.text = q.ques
        tvopt1?.text = q.opt1
        tvopt2?.text = q.opt2
        tvopt3?.text = q.opt3
        tvopt4?.text = q.opt4
    }
    private fun defaultOptionView(){
        val options=ArrayList<TextView>()
        tvopt1?.let {
            options.add(0,it)
        }
        tvopt2?.let {
            options.add(1,it)
        }
        tvopt3?.let {
            options.add(2,it)
        }
        tvopt4?.let {
            options.add(3,it)
        }
        for (i in options){
            i.setTextColor(Color.parseColor("#7A8089"))
            i.typeface= Typeface.DEFAULT
            i.background=ContextCompat.getDrawable(
                this@Activityquestion,
                R.drawable.default_background
            )
        }
    }



    private fun SelOptView(tv:TextView,SelOptNo:Int){
        defaultOptionView()
        SelOptPos=SelOptNo
        tv.setTextColor(Color.parseColor("#363A43"))
    tv.setTypeface(tv.typeface,Typeface.BOLD)
        tv.background=ContextCompat.getDrawable(
            this@Activityquestion,
            R.drawable.selected_option_bg
        )
    }

    override fun onClick(p0: View?) {
        when(p0?.id){
            R.id.tv_opt1->{
                tvopt1?.let {
                    SelOptView(it, 1)
                }
            }
            R.id.tv_opt2-> {
                tvopt2?.let {
                    SelOptView(it, 2)
                }
            }
            R.id.tv_opt3-> {
                tvopt3?.let {
                    SelOptView(it, 3)
                }
            }
            R.id.tv_opt4-> {
                tvopt4?.let {
                    SelOptView(it, 4)
                }
            }
            R.id.btn_submit->{
                if(SelOptPos==0){
                    currPos++
                    when{
                        currPos<=GQList!!.size->{

                            setQuestion()
                        }
                        else->{
                            //Toast.makeText(this@Activityquestion, "You have successfully completed the quiz. Your Score is : $corrans", Toast.LENGTH_LONG).show()
                        val intent_result= Intent(this,ResultActivity::class.java)
                         intent_result.putExtra(questions.USER_NAME,Username)
                            intent_result.putExtra(questions.CORRECT_ANSWER,corrans)
                            intent_result.putExtra(questions.TOTAL_QUESTION,GQList?.size)
                            startActivity(intent_result)
                            finish()
                        }
                    }
                }else{
                    val ques=GQList?.get(currPos-1)

                    if(ques!!.correctans!=SelOptPos){
                        answerView(SelOptPos,R.drawable.wrong_option_bg)
                    }
                    else{
                        corrans++;
                    }
                    answerView(ques.correctans,R.drawable.correct_option_bg)
                    if(currPos==GQList!!.size){
                        btnsubmit?.text="FINISH"
                    }else{
                        btnsubmit?.text="GO TO NEXT QUESTION"
                    }
                    SelOptPos=0
                }
            }
        }
    }



    private fun answerView(ans:Int,drawable :Int){
        when(ans){
            1-> {

                tvopt1?.background = ContextCompat.getDrawable(
                    this@Activityquestion,
                    drawable
                )
            }

          2->  {
                tvopt2?.background = ContextCompat.getDrawable(
                    this@Activityquestion,
                    drawable
                )
            }
           3-> {
                tvopt3?.background = ContextCompat.getDrawable(
                    this@Activityquestion,
                    drawable
                )
            }
           4-> {
                tvopt4?.background = ContextCompat.getDrawable(
                    this@Activityquestion,
                    drawable
                )
            }
            }

        }

    }

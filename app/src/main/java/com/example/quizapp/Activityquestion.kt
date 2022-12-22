package com.example.quizapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.SyncStateContract
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView

class Activityquestion : AppCompatActivity() {
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
        progressBar=findViewById(R.id.PB)
        tvprogress=findViewById(R.id.tv_ProgressBar)
        tvquestion=findViewById(R.id.tv_question)
        tvopt1=findViewById(R.id.tv_opt1)
        tvopt2=findViewById(R.id.tv_opt2)
        tvopt3=findViewById(R.id.tv_opt3)
        tvopt4=findViewById(R.id.tv_opt4)
        btnsubmit=findViewById(R.id.btn_submit)
        val Qlist=questions.getquestion()
        Log.i("QuestionList size is","${Qlist.size}")
        for (i in Qlist){
            Log.e("Questions",i.ques)
        }
        var curr_Q=1
        val q:Question=Qlist[curr_Q-1]
        progressBar?.progress=curr_Q
        tvprogress?.text="($curr_Q)/${progressBar?.max}"
        tvquestion?.text=q.ques
        tvopt1?.text=q.opt1
        tvopt2?.text=q.opt2
        tvopt3?.text=q.opt3
        tvopt4?.text=q.opt4




    }
}
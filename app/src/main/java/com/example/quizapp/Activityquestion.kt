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
    private var ivimage:ImageView?=null
    private var tvopt1:TextView?=null
    private var tvopt2:TextView?=null
    private var tvopt3:TextView?=null
    private var tvopt4:TextView?=null
    private var btnsubmit:Button?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_activityquestion)
        val Qlist=questions.getquestion()
        Log.e("QuestionList size is","${Qlist.size}")
        for (i in Qlist){
            Log.e("Questions",i.ques)
        }
        val curr_Q=1
        val q:Question?=Qlist[(curr_Q)-1]


    }
}
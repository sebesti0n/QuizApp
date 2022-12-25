package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        val tvname:TextView=findViewById(R.id.tv_name)
        val tvscore:TextView=findViewById(R.id.tv_score)
        val btnfinish:Button=findViewById(R.id.btn_finish)


        tvname.text=intent.getStringExtra(questions.USER_NAME,)
      //  tvscore.text=intent.getStringExtra(questions.CORRECT_ANSWER)
        val tot_Ques=intent.getIntExtra(questions.TOTAL_QUESTION,0)
        val correctanswer=intent.getIntExtra(questions.CORRECT_ANSWER,0)
        tvscore.text="Your Score is $correctanswer out of $tot_Ques"

        btnfinish.setOnClickListener{
            startActivity(Intent( this,MainActivity::class.java))

        }
    }
}
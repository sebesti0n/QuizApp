package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val start_btn:Button=findViewById(R.id.quiz_start_btn)
        val player_name:EditText=findViewById(R.id.name)
        start_btn.setOnClickListener{
            if(player_name.text.isEmpty()){
                Toast.makeText(this,"please enter your Name",Toast.LENGTH_LONG).show()
            }
            else {
                val intent=Intent(this,Activityquestion::class.java)
                startActivity(intent)
                finish()
            }
        }
    }
}
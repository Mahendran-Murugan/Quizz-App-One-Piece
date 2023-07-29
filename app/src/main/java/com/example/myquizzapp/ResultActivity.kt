package com.example.myquizzapp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class ResultActivity : AppCompatActivity() {
    private var tvUser : TextView? = null
    private var tvScore : TextView? = null
    private var btnFinish : Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        tvUser = findViewById(R.id.tv_usr_name)
        tvScore = findViewById(R.id.tv_score)
        btnFinish = findViewById(R.id.btnFinish)
        tvUser?.text = intent.getStringExtra(Constants.tv_usr_name)
        tvScore?.text = "Your Score is ${(intent.getStringExtra(Constants.correct_answer))} out of ${intent.getStringExtra(Constants.total_question)}"
        btnFinish?.setOnClickListener(){
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
    }


}


